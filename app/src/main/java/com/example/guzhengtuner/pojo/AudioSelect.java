package com.example.guzhengtuner.pojo;

public class AudioSelect {

    private int pick1;
    private int pick2;
    private double rs;

    public double findRs(int pick1, int pick2) {
        if (pick1==0){
            switch (pick2){ //D调
                case 1:
                    rs= AudioEnum.D_1.getAudio();
                    break;
                case 2:
                    rs= AudioEnum.D_2.getAudio();
                    break;
                case 3:
                    rs= AudioEnum.D_3.getAudio();
                    break;
                case 4:
                    rs= AudioEnum.D_4.getAudio();
                    break;
                case 5:
                    rs= AudioEnum.D_5.getAudio();
                    break;
                case 6:
                    rs= AudioEnum.D_6.getAudio();
                    break;
                case 7:
                    rs= AudioEnum.D_7.getAudio();
                    break;
                case 8:
                    rs= AudioEnum.D_8.getAudio();
                    break;
                case 9:
                    rs= AudioEnum.D_9.getAudio();
                    break;
                case 10:
                    rs= AudioEnum.D_10.getAudio();
                    break;
                case 11:
                    rs= AudioEnum.D_11.getAudio();
                    break;
                case 12:
                    rs= AudioEnum.D_12.getAudio();
                    break;
                case 13:
                    rs= AudioEnum.D_13.getAudio();
                    break;
                case 14:
                    rs= AudioEnum.D_14.getAudio();
                    break;
                case 15:
                    rs= AudioEnum.D_15.getAudio();
                    break;
                case 16:
                    rs= AudioEnum.D_16.getAudio();
                    break;
                case 17:
                    rs= AudioEnum.D_17.getAudio();
                    break;
                case 18:
                    rs= AudioEnum.D_18.getAudio();
                    break;
                case 19:
                    rs= AudioEnum.D_19.getAudio();
                    break;
                case 20:
                    rs= AudioEnum.D_20.getAudio();
                    break;
                case 21:
                    rs= AudioEnum.D_21.getAudio();
            }
        }else if (pick1==1){//G调
            switch (pick2){
                case 1:
                    rs= AudioEnum.D_1.getAudio();
                    break;
                case 2:
                    rs= AudioEnum.D_2.getAudio();
                    break;
                case 3:
                    rs= AudioEnum.D_3.getAudio();
                    break;
                case 4:
                    rs= AudioEnum.G_4.getAudio();
                    break;
                case 5:
                    rs= AudioEnum.D_5.getAudio();
                    break;
                case 6:
                    rs= AudioEnum.D_6.getAudio();
                    break;
                case 7:
                    rs= AudioEnum.D_7.getAudio();
                    break;
                case 8:
                    rs= AudioEnum.D_8.getAudio();
                    break;
                case 9:
                    rs= AudioEnum.G_9.getAudio();
                    break;
                case 10:
                    rs= AudioEnum.D_10.getAudio();
                    break;
                case 11:
                    rs= AudioEnum.D_11.getAudio();
                    break;
                case 12:
                    rs= AudioEnum.D_12.getAudio();
                    break;
                case 13:
                    rs= AudioEnum.D_13.getAudio();
                    break;
                case 14:
                    rs= AudioEnum.G_14.getAudio();
                    break;
                case 15:
                    rs= AudioEnum.D_15.getAudio();
                    break;
                case 16:
                    rs= AudioEnum.D_16.getAudio();
                    break;
                case 17:
                    rs= AudioEnum.D_17.getAudio();
                    break;
                case 18:
                    rs= AudioEnum.D_18.getAudio();
                    break;
                case 19:
                    rs= AudioEnum.G_19.getAudio();
                    break;
                case 20:
                    rs= AudioEnum.D_20.getAudio();
                    break;
                case 21:
                    rs= AudioEnum.D_21.getAudio();
            }
        }else if (pick1==2){ //C调
            switch (pick2) {
                case 1:
                    rs = AudioEnum.D_1.getAudio();
                    break;
                case 2:
                    rs = AudioEnum.C_2.getAudio();
                    break;
                case 3:
                    rs = AudioEnum.D_3.getAudio();
                    break;
                case 4:
                    rs = AudioEnum.G_4.getAudio();
                    break;
                case 5:
                    rs = AudioEnum.D_5.getAudio();
                    break;
                case 6:
                    rs = AudioEnum.D_6.getAudio();
                    break;
                case 7:
                    rs = AudioEnum.C_7.getAudio();
                    break;
                case 8:
                    rs = AudioEnum.D_8.getAudio();
                    break;
                case 9:
                    rs = AudioEnum.G_9.getAudio();
                    break;
                case 10:
                    rs = AudioEnum.D_10.getAudio();
                    break;
                case 11:
                    rs = AudioEnum.D_11.getAudio();
                    break;
                case 12:
                    rs = AudioEnum.D_12.getAudio();
                    break;
                case 13:
                    rs = AudioEnum.D_13.getAudio();
                    break;
                case 14:
                    rs = AudioEnum.G_14.getAudio();
                    break;
                case 15:
                    rs = AudioEnum.D_15.getAudio();
                    break;
                case 16:
                    rs = AudioEnum.D_16.getAudio();
                    break;
                case 17:
                    rs = AudioEnum.C_17.getAudio();
                    break;
                case 18:
                    rs = AudioEnum.D_18.getAudio();
                    break;
                case 19:
                    rs = AudioEnum.G_19.getAudio();
                    break;
                case 20:
                    rs = AudioEnum.D_20.getAudio();
                    break;
                case 21:
                    rs = AudioEnum.D_21.getAudio();
                }
            }else if (pick1==2){ //C调
                switch (pick2){
                    case 1:
                        rs= AudioEnum.D_1.getAudio();
                        break;
                    case 2:
                        rs= AudioEnum.C_2.getAudio();
                        break;
                    case 3:
                        rs= AudioEnum.D_3.getAudio();
                        break;
                    case 4:
                        rs= AudioEnum.G_4.getAudio();
                        break;
                    case 5:
                        rs= AudioEnum.D_5.getAudio();
                        break;
                    case 6:
                        rs= AudioEnum.D_6.getAudio();
                        break;
                    case 7:
                        rs= AudioEnum.C_7.getAudio();
                        break;
                    case 8:
                        rs= AudioEnum.D_8.getAudio();
                        break;
                    case 9:
                        rs= AudioEnum.G_9.getAudio();
                        break;
                    case 10:
                        rs= AudioEnum.D_10.getAudio();
                        break;
                    case 11:
                        rs= AudioEnum.D_11.getAudio();
                        break;
                    case 12:
                        rs= AudioEnum.D_12.getAudio();
                        break;
                    case 13:
                        rs= AudioEnum.D_13.getAudio();
                        break;
                    case 14:
                        rs= AudioEnum.G_14.getAudio();
                        break;
                    case 15:
                        rs= AudioEnum.D_15.getAudio();
                        break;
                    case 16:
                        rs= AudioEnum.D_16.getAudio();
                        break;
                    case 17:
                        rs= AudioEnum.C_17.getAudio();
                        break;
                    case 18:
                        rs= AudioEnum.D_18.getAudio();
                        break;
                    case 19:
                        rs= AudioEnum.G_19.getAudio();
                        break;
                    case 20:
                        rs= AudioEnum.D_20.getAudio();
                        break;
                    case 21:
                        rs= AudioEnum.D_21.getAudio();
                }
             }else if (pick1==3){ //F调
                switch (pick2){
                    case 1:
                        rs= AudioEnum.D_1.getAudio();
                        break;
                    case 2:
                        rs= AudioEnum.C_2.getAudio();
                        break;
                    case 3:
                        rs= AudioEnum.D_3.getAudio();
                        break;
                    case 4:
                        rs= AudioEnum.G_4.getAudio();
                        break;
                    case 5:
                        rs= AudioEnum.F_5.getAudio();
                        break;
                    case 6:
                        rs= AudioEnum.D_6.getAudio();
                        break;
                    case 7:
                        rs= AudioEnum.C_7.getAudio();
                        break;
                    case 8:
                        rs= AudioEnum.D_8.getAudio();
                        break;
                    case 9:
                        rs= AudioEnum.G_9.getAudio();
                        break;
                    case 10:
                        rs= AudioEnum.F_10.getAudio();
                        break;
                    case 11:
                        rs= AudioEnum.D_11.getAudio();
                        break;
                    case 12:
                        rs= AudioEnum.D_12.getAudio();
                        break;
                    case 13:
                        rs= AudioEnum.D_13.getAudio();
                        break;
                    case 14:
                        rs= AudioEnum.G_14.getAudio();
                        break;
                    case 15:
                        rs= AudioEnum.F_15.getAudio();
                        break;
                    case 16:
                        rs= AudioEnum.D_16.getAudio();
                        break;
                    case 17:
                        rs= AudioEnum.C_17.getAudio();
                        break;
                    case 18:
                        rs= AudioEnum.D_18.getAudio();
                        break;
                    case 19:
                        rs= AudioEnum.G_19.getAudio();
                        break;
                    case 20:
                        rs= AudioEnum.F_20.getAudio();
                        break;
                    case 21:
                        rs= AudioEnum.D_21.getAudio();
                }
        }else if (pick1==4){ //B#调
            switch (pick2){
                case 1:
                    rs= AudioEnum.D_1.getAudio();
                    break;
                case 2:
                    rs= AudioEnum.C_2.getAudio();
                    break;
                case 3:
                    rs= AudioEnum.B_SHARP_3.getAudio();
                    break;
                case 4:
                    rs= AudioEnum.G_4.getAudio();
                    break;
                case 5:
                    rs= AudioEnum.F_5.getAudio();
                    break;
                case 6:
                    rs= AudioEnum.D_6.getAudio();
                    break;
                case 7:
                    rs= AudioEnum.C_7.getAudio();
                    break;
                case 8:
                    rs= AudioEnum.B_SHARP_8.getAudio();
                    break;
                case 9:
                    rs= AudioEnum.G_9.getAudio();
                    break;
                case 10:
                    rs= AudioEnum.F_10.getAudio();
                    break;
                case 11:
                    rs= AudioEnum.D_11.getAudio();
                    break;
                case 12:
                    rs= AudioEnum.D_12.getAudio();
                    break;
                case 13:
                    rs= AudioEnum.B_SHARP_13.getAudio();
                    break;
                case 14:
                    rs= AudioEnum.G_14.getAudio();
                    break;
                case 15:
                    rs= AudioEnum.F_15.getAudio();
                    break;
                case 16:
                    rs= AudioEnum.D_16.getAudio();
                    break;
                case 17:
                    rs= AudioEnum.C_17.getAudio();
                    break;
                case 18:
                    rs= AudioEnum.B_SHARP_18.getAudio();
                    break;
                case 19:
                    rs= AudioEnum.G_19.getAudio();
                    break;
                case 20:
                    rs= AudioEnum.F_20.getAudio();
                    break;
                case 21:
                    rs= AudioEnum.D_21.getAudio();
            }
        }
        return rs;
    }
}
