package com.example.guzhengtuner.pojo;

public enum AudioEnum {

    D_1(0,1,1174.659),
    D_2(0,2,987.767),
    D_3(0,3,880.000),
    D_4(0,4,739.989),
    D_5(0,5,659.255),
    D_6(0,6,587.330),
    D_7(0,7,493.883),
    D_8(0,8,440.000),
    D_9(0,9,371.228),
    D_10(0,10,329.628 ),
    D_11(0,11,293.665),
    D_12(0,12,246.942),
    D_13(0,13,220.000),
    D_14(0,14,184.997),
    D_15(0,15,164.814),
    D_16(0,16,146.832),
    D_17(0,17,123.471),
    D_18(0,18,110.000	),
    D_19(0,19,92.499),
    D_20(0,20, 82.407),
    D_21(0,21, 73.416),

    G_4(1,4,783.991),
    G_9(1,9,391.995),
    G_14(1,14,195.998),
    G_19(1,19,97.999),

    C_2(2,2,1046.502),
    C_7(2,7,523.251),
    C_12(2,12,261.626),
    C_17(2,17,130.813),

    F_5(3,5,698.456),
    F_10(3,10,349.228),
    F_15(3,15,174.614	),
    F_20(3,20,87.307),

    B_SHARP_3(4,3,932.328),
    B_SHARP_8(4,8,466.164),
    B_SHARP_13(4,13,233.082),
    B_SHARP_18(4,18,116.541);

    private int pick1;
    private int pick2;
    private double audio;



    AudioEnum(int i, int i1, double v) {
        this.pick1=i;
        this.pick2=i1;
        this.audio=v;
    }



    public int getPick1() {
        return pick1;
    }

    public void setPick1(int pick1) {
        this.pick1 = pick1;
    }

    public int getPick2() {
        return pick2;
    }

    public void setPick2(int pick2) {
        this.pick2 = pick2;
    }

    public double getAudio() {
        return audio;
    }

    public void setAudio(double audio) {
        this.audio = audio;
    }
}

