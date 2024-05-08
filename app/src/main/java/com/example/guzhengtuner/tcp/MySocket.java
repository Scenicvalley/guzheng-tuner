package com.example.guzhengtuner.tcp;

public class MySocket {
    private String ip;
    private int port;
    private String msg;

    public MySocket(String ip, int port,String msg) {
        this.ip = ip;
        this.port = port;
        this.msg=msg;
    }

    public MySocket() {
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
