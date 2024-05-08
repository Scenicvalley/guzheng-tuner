package com.example.guzhengtuner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.guzhengtuner.dispose.ListenerFragment;
import com.example.guzhengtuner.dispose.TaskCallbacks;
import com.example.guzhengtuner.note.NoteFrequencyCalculator;
import com.example.guzhengtuner.pojo.AudioSelect;
import com.example.guzhengtuner.pojo.PitchDifference;
import com.example.guzhengtuner.tcp.MySocket;
import com.example.guzhengtuner.tcp.TcpClient;
import com.shawnlin.numberpicker.NumberPicker;

import java.io.IOException;

import J.N;

public class MainActivity2 extends AppCompatActivity implements NumberPicker.OnValueChangeListener , TaskCallbacks {
    private int pick1=0;
    private int pick2=0;
    private int msg;
    private ListenerFragment listenerFragment;
    private static final String TAG_LISTENER_FRAGMENT = "listener_fragment";
    private double standardFrequency=1174.659;
    private AudioSelect audioSelect;
    private String SERVER_IP;
    private int SERVER_PORT;
    private TcpClient tcpClient;

    private String[] tones;
    private String[] stringNumbers;
    private NumberPicker numberPicker1;
    private NumberPicker numberPicker2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //设置显示的弦号
        tones= new String[]{"D调", "G调", "C调", "F调", "B#调"};
        numberPicker1= findViewById(R.id.numberPicker1);
        numberPicker1.setMinValue(0);
        numberPicker1.setMaxValue(tones.length-1);
        numberPicker1.setDisplayedValues(tones);
        //设置显示的数字
        stringNumbers= new String[]{"第一根弦", "第二根弦", "第三根弦", "第四根弦", "第五根弦", "第六根弦", "第七根弦", "第八根弦", "第九根弦", "第十根弦",
                "第十一根弦", "第十二根弦", "第十三根弦", "第十四根弦", "第十五根弦", "第十六根弦", "第十七根弦", "第十八根弦", "第十九根弦", "第二十根弦",
                "第二一根弦"};
        numberPicker2= findViewById(R.id.numberPicker2);
        numberPicker2.setMinValue(0);
        numberPicker2.setMaxValue(stringNumbers.length-1);
        numberPicker2.setDisplayedValues(stringNumbers);
        // 默认显示"D调"与"第一根弦"
        numberPicker1.setValue(0);
        numberPicker2.setValue(0);
        numberPicker1.setOnValueChangedListener(this);
        numberPicker2.setOnValueChangedListener(this);
        startRecording();
    }

    //开始录音
    private void startRecording() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        listenerFragment = (ListenerFragment) fragmentManager.findFragmentByTag(TAG_LISTENER_FRAGMENT);
        if (listenerFragment == null) {
            listenerFragment = new ListenerFragment();
            fragmentManager
                    .beginTransaction()
                    .add(listenerFragment, TAG_LISTENER_FRAGMENT)
                    .commit();
        }
    }

    //动态监听选择器选择的内容并且赋值给两个选择的常量
    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
        if (picker.getId()==R.id.numberPicker1){
            pick1=picker.getValue();
        }else{
            pick2=picker.getValue();
        }
        startUpdate();
        Button button=findViewById(R.id.btn);
        button.setText("点击发送");
        button.setBackgroundColor(Color.BLUE);
    }

    private void startUpdate() {
        if (audioSelect==null){
            audioSelect=new AudioSelect();
        }
        standardFrequency=audioSelect.findRs(pick1,pick2+1);
    }


    @Override
    public void getMessageFromFragment(PitchDifference rs) {
        if (audioSelect==null){
            audioSelect=new AudioSelect();
        }
        Double rsFrequency=new NoteFrequencyCalculator().getFrequency(rs.getClosest())+rs.getDeviation();
        Float rsFrequency2= rsFrequency.floatValue();
        int compareRs=compareFrequncy(rsFrequency,standardFrequency);
        TextView textView= findViewById(R.id.res);
        TextView textView1=findViewById(R.id.res1);
        textView.setText(rsFrequency2.toString());
        Log.e("rsFrequency",rsFrequency.toString());
        if(compareRs ==0){
            Log.e("rs","偏低");
            textView1.setText("偏低");
        }else if (compareRs==1){
            Log.e("rs","正常");
            textView1.setText("正常");
        }else{
            Log.e("rs","偏高");
            textView1.setText("偏高");
        }
        Button button=findViewById(R.id.btn);
        button.setText("点击发送");
        button.setBackgroundColor(Color.BLUE);

    }

    private int compareFrequncy(Double frequency,Double standardFrequency) {
        double rs = frequency-standardFrequency;
        if (rs > 10) {
            msg=2;
            return msg;
        } else if (rs < -10) {
            msg=0;
            return msg;
        } else {
            msg=1;
            return msg;
        }
    }

    public void sendMsg(View view) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                tcpClient.setMsg(msg);
                tcpClient.run();
            }
        }).start();
        Button button=findViewById(R.id.btn);
        button.setText("发送成功");
        button.setBackgroundColor(Color.RED);
    }

    public void getConnection(View view) {
        EditText editText1=findViewById(R.id.et1);
        EditText editText2=findViewById(R.id.et2);

        SERVER_IP= editText1.getText().toString();
        SERVER_PORT=Integer.parseInt(editText2.getText().toString());
        Button button=findViewById(R.id.btn2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                tcpClient=TcpClient.getInstance(SERVER_IP,SERVER_PORT);
                tcpClient.getConnection();
                if (tcpClient.getSocket().isConnected()){
                   Runnable ui = new Runnable() {
                       @Override
                       public void run() {
                           Log.e("socket","连接成功");
                           button.setText("连接成功");
                           button.setBackgroundColor(Color.RED);
                       }
                   };
                    Handler handler =new Handler(Looper.getMainLooper());
                    handler.post(ui);
                }
            }
        }).start();
    }

}