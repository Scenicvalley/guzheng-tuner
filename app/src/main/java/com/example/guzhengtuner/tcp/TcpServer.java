package com.example.guzhengtuner.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpServer extends Thread{

    private String msg;

    public static final int SERVICE_PORT = 10101;

    public TcpServer(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        ServerSocket serverSocket = null;
        try {
            //封装服务端地址
            serverSocket = new ServerSocket(SERVICE_PORT);
            System.out.println("--开启服务器--");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 监听端口，等待客户端连接
        while (true) {
            System.out.println("--等待客户端连接--");
            Socket socket = null; //等待客户端连接
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("得到客户端连接：" + socket);
            serverSendMessage(msg,socket);
        }  
        
    }

    private static void startReader(final Socket mSocket) {
        new Thread(){
            @Override
            public void run() {
                try {
                    // 获取读取流
                    BufferedReader in = new BufferedReader(new InputStreamReader(mSocket.getInputStream(),"utf-8"));
                    String line="";
                    while ((line = in.readLine()) != null) {// 读取数据
                        System.out.println("*等待客户端输入*");
                        System.out.println("获取到客户端的信息：" + line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    //通过socket来给客户端发送消息
    private void serverSendMessage(String mServerSendMessage,final Socket mSocket) {
        new Thread() {
            @Override
            public void run() {
                PrintWriter out;
                try {
                    out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(mSocket.getOutputStream())), true);
                    out.println(mServerSendMessage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
