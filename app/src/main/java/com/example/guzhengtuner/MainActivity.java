package com.example.guzhengtuner;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


import android.Manifest;

import android.content.Intent;
import android.content.pm.PackageManager;
;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.example.guzhengtuner.exception.ExceptionHandler;

public class MainActivity extends AppCompatActivity{

    private static final int PERMISSION_MICROPHONE_CAMERA= 101; //麦克风requestCode

    private boolean isExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getMicrophonePermission();
        //初始化Crash
        initCrashHandler();
    }

    public void startActivity2(View view) {
        startActivity(new Intent(this,MainActivity2.class));
    }

    /**
     * 获取单个权限-储存
     * checkSelfPermission检查app是否已获取到权限?已获取到返回值为 0，否则前去获取
     * requestPermissions用于获取权限，需传递三个参数，分别为:
     * 1.activity
     * 2.String[] 想要获取的哪些权限，储存在字符串数组内.(可以同时获取多个权限，或单个权限)
     * 3.int      请求代码 - 自己定义
     **/

    //同时获取多个个权限-麦克风-照相机
    public void getMicrophonePermission() {
        //检查app是否已获取到权限
        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(getApplicationContext(),"已获取到麦克风权限 ",Toast.LENGTH_SHORT).show();
        }else {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.RECORD_AUDIO},
                    PERMISSION_MICROPHONE_CAMERA);
        }
    }

    /**
     * 用户拒绝或同意权限后的回调。
     * requestCode 请求的时候设置的int
     * String[] permissions 请求过的权限
     * int[] grantResults  请求权限的结果，同意 == 0，拒绝 == -1
     **/

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (grantResults[0]==0){
            Toast.makeText(getApplicationContext(),"麦克风权限回调结果: 同意",Toast.LENGTH_SHORT).show();
        }else if (grantResults[0]==-1){
            Toast.makeText(getApplicationContext(),"麦克风权限回调结果: 拒绝",Toast.LENGTH_SHORT).show();
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }


    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            isExit = false;
        }

    };

    public void exit(){
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent);
            System.exit(0);
        }
    }

    private void initCrashHandler() {
        //ExceptionHander的使用
        ExceptionHandler.install(new ExceptionHandler.CustomExceptionHandler() {
            @Override
            public void handlerException(Thread thread, Throwable throwable) {
                if (throwable != null) {
                    Log.e("060ExceptionHandler===", throwable.getMessage() + "");
                }
            }
        });

    }



}