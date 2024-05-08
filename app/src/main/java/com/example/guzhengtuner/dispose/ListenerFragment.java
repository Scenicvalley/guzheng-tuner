package com.example.guzhengtuner.dispose;

import android.app.Activity;
import android.content.Context;


import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.guzhengtuner.note.Note;
import com.example.guzhengtuner.note.NoteFrequencyCalculator;
import com.example.guzhengtuner.note.Pitch;
import com.example.guzhengtuner.pojo.AudioSelect;
import com.example.guzhengtuner.pojo.PitchDifference;
import com.example.guzhengtuner.util.Sampler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.io.android.AudioDispatcherFactory;
import be.tarsos.dsp.pitch.PitchDetectionHandler;
import be.tarsos.dsp.pitch.PitchProcessor;


public class ListenerFragment extends Fragment {

    //回调函数用于与activity进行通信
    private static TaskCallbacks taskCallbacks;
    //用于处理音频
    private PitchListener pitchListener;
    private static List<PitchDifference> pitchDifferences = new ArrayList<>(); // 用于存储音高差异对象



    //Activity或Context与Fragment关联起来，并初始化taskCallbacks。
    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }



    //Fragment创建时被调用，设置保持实例以及启动PitchListener。
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        pitchListener=new PitchListener();
        pitchListener.execute();
    }

    //Fragment与Activity或Context解除关联时被调用
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        taskCallbacks =(TaskCallbacks) context;
    }


    //Fragment暂停时被调用，取消PitchListener。
    @Override
    public void onPause() {
        super.onPause();
        pitchListener.cancel(true);
    }

    //在Fragment恢复时被调用，重新启动PitchListener。
    @Override
    public void onResume() {
        super.onResume();
        if (pitchListener.isCancelled()) {
            pitchListener = new PitchListener();
            pitchListener.execute();
        }
    }




    public  static class PitchListener extends AsyncTask<Void, PitchDifference, Float> {

        //采样率，表示每秒钟对声音信号进行多少次采样。在这里，采样率设置为44100。
        private static final int SAMPLE_RATE = 44100;
        //定义了音频缓冲区的大小。在这里，缓冲区大小设置为1024 * 4。
        private static final int BUFFER_SIZE = 1024 * 4;
        //常量定义了重叠的大小。在这里，重叠大小设置为768 * 4。
        private static final int OVERLAP = 768 * 4;
        //最小项目数量，当采集到的音高差异达到该数量时，会计算平均差异值并发布进度更新
        private static final int MIN_ITEMS_COUNT = 15;
        private AudioDispatcher audioDispatcher;
        //定义了一个可以计算频率的工具类
        NoteFrequencyCalculator noteFrequencyCalculator =new NoteFrequencyCalculator();



        // 这里对应的是古筝D调的标准音高
        private String[][] pitchArray = {
                {"D6",
                        "B5","A5","F5_SHARP","E5","D5",
                        "B4","A4","F4_SHARP","E4","D4",
                        "B3","A3","F3_SHARP","E3","D3",
                        "B2","A2","F2_SHARP","E2","D2"},
        };



        // 这个方法在子线程中执行，负责处理耗时操作。任务一旦完成就可以通过return语句来将任务的执行结果进行返回，如果AsyncTask的第三个参数指定的是Void，就可以不返回执行结果。
        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        protected Float doInBackground(Void... voids) {

            //定义处理细则
            PitchDetectionHandler pitchDetectionHandler = (pitchDetectionResult, audioEvent) -> {
                //pitch是每次取样获取的频率
                float pitch = pitchDetectionResult.getPitch();
                System.out.println(pitch);
                if (pitch != -1) {
                    double minCentDifference = Double.POSITIVE_INFINITY;
                    //拿到所有的枚举类
                    Note[] notes = Pitch.values();
                    //将notes中的所有标准音的频率给计算出来，然后排序
                    Arrays.sort(notes, Comparator.comparingDouble(noteFrequencyCalculator::getFrequency));
                    //寻找最接近的音阶
                    Note closest = notes[0];
                        for (Note note : notes) {
                            double frequency = noteFrequencyCalculator.getFrequency(note);
                            double centDifference = pitch-frequency;
                            if (Math.abs(centDifference) < Math.abs(minCentDifference)) {
                                minCentDifference = centDifference;
                                closest = note;
                            }
                        }
                        PitchDifference pitchDifference = new PitchDifference(closest, minCentDifference);
                        pitchDifferences.add(pitchDifference);
                    if (pitchDifferences.size()>=MIN_ITEMS_COUNT){
                        PitchDifference average = Sampler.calculateAverageDifference(pitchDifferences);
                        assert average != null;
                        for (int i=0; i<pitchArray[0].length; i++){
                            if (String.valueOf(average.getClosest()).equals(pitchArray[0][i])){
                                Log.d("最接近音频", String.valueOf(average.getClosest()));
                                Log.d("平均偏差",String.valueOf(average.getDeviation()));
                                break;
                            }
                        }
                        //出现频率最高的标准音高的频率
                        Double closetFrequency= noteFrequencyCalculator.getFrequency(average.getClosest());
                        //标准频率加上平均偏差，得到的也就是一个有效样本的平均值
                        Double averageFrequency= closetFrequency+average.getDeviation();
                        publishProgress(average);
                        pitchDifferences.clear();
                    }
                }
            };



            //处理声音
            PitchProcessor pitchProcessor = new PitchProcessor(PitchProcessor.PitchEstimationAlgorithm.FFT_YIN,
                    SAMPLE_RATE,
                    BUFFER_SIZE, pitchDetectionHandler);

            audioDispatcher = AudioDispatcherFactory.fromDefaultMicrophone(SAMPLE_RATE,
                    BUFFER_SIZE, OVERLAP);

            audioDispatcher.addAudioProcessor(pitchProcessor);

            audioDispatcher.run();

            return null;
        }



        //一旦实行publishProgress方法就可以在主进程中的这个方法中拿到值
        //用于更新任务的进度信息。该函数的调用频率取决于任务的性质和执行环境。在每次调用onProgressUpdate函数时
        // ，都可以更新UI界面或其他相关的任务信息。因此，onProgressUpdate函数可以随着任务的执行而动态地更新任务进度。
        @Override
        protected void onProgressUpdate(PitchDifference... values) {
            PitchDifference pitchDifference = values[0];
            System.out.println("拿到音高："+pitchDifference.toString());
            // 在这里处理频率对比结果，可以将结果返回给调用者或进行其他操作
            if (taskCallbacks != null) {
                taskCallbacks.getMessageFromFragment(pitchDifference);
            }
        }


    }




}
