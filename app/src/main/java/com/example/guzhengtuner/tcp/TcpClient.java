package com.example.guzhengtuner.tcp;

import android.content.IntentFilter;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClient extends Thread{

    private int msg;
    private OutputStream outputStream;
    private InputStream inputStream;
    private String ip;
    private int port;
    public Socket socket;
    private static TcpClient instance;


    public static TcpClient getInstance(String ip,int port) {
        if (instance!=null){
            if (instance.ip==ip&&instance.port==port){
                return instance;
            }else {
               instance = new TcpClient(ip,port);
                return instance;
            }
        }else {
            instance =new TcpClient(ip,port);
        }
        return instance;
    }


    public TcpClient(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public int getMsg() {
        return msg;
    }

    public void setMsg(int msg) {
        this.msg = msg;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public void getConnection(){
        try {
            socket = new Socket(ip,port);
            System.out.println("建立连接");
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            //目标主机与端口
            outputStream.write((msg+"\n").getBytes("utf-8"));
            outputStream.flush();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
