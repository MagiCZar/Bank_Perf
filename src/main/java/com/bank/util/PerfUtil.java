package com.bank.util;

import com.bank.bean.*;

import java.util.List;

public class PerfUtil {
    public static int[] numCal(int id, List list){
        int[] num = new int[4];
        switch (id/1000){
            case 11:
                for (Object aList : list) {
                    AssetCus assetCus = (AssetCus) aList;
                    num[0] += assetCus.getNumber();
                }
                break;
            case 12:
                for (Object aList : list) {
                    LiaCus liaCus = (LiaCus) aList;
                    num[0] += liaCus.getNumber();
                }
                break;
            case 13:
                for (Object aList : list) {
                    MiddleCus middleCus = (MiddleCus) aList;
                    switch (middleCus.getType()){
                        case "委托贷款业务":
                            num[0] += middleCus.getNumber();
                            break;
                        case "投资银行业务":
                            num[1] += middleCus.getNumber();
                            break;
                        case "担保承诺业务":
                            num[2] += middleCus.getNumber();
                            break;
                        case "现金管理业务":
                            num[3] += middleCus.getNumber();
                            break;
                    }
                }
                break;
            case 14:
                for (Object aList : list) {
                    PersonCus personCus = (PersonCus) aList;
                    switch (personCus.getType()){
                        case "负债业务":
                            num[0] += personCus.getNumber();
                            break;
                        case "贷款业务":
                            num[1] += personCus.getNumber();
                            break;
                        case "支付结算业务":
                            num[2] += personCus.getNumber();
                            break;
                        case "代理业务":
                            num[3] += personCus.getNumber();
                            break;
                    }
                }
                break;
        }
        return num;
    }
    public static int perfCal(int id,int[] number,int attendance,Performance performance){
        int perf = 0;
        switch (id/1000){
            case 11:
                perf = (int) (assliaCal(number[0]) * performance.getPerf1() + attendance * performance.getAttendence());
                break;
            case 12:
                perf = (int) (assliaCal(number[0]) * performance.getPerf1() + attendance * performance.getAttendence());
                break;
            case 13:
                perf = (midperCal(number,attendance,performance));
                break;
            case 14:
                perf = (midperCal(number,attendance,performance));
                break;
        }
        return perf;
    }

    private static int assliaCal(int num){
        int score = 0;
        if (num < 3000){
            score += 0;
        }else if (num < 5000){
            score += 60 + (num - 3000)/50;
        }else {
            score += 100;
        }
        return score;
    }
    private static int midperCal(int[] num,int attendance,Performance performance){
        int score = (int) (assliaCal(num[0] * 10) * performance.getPerf1()
                        + assliaCal(num[1] * 10) * performance.getPerf2()
                        + assliaCal(num[2] * 10) * performance.getPerf3()
                        + assliaCal(num[3] * 10) * performance.getPerf4()
                        + attendance * performance.getAttendence());
        return score;
    }
}
