package com.bank.util;

import com.bank.bean.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class InfTransUtil {
    public static Information inf_trans(List list,int id){
        Information information = new Information();
        switch (id/1000){
            case 11:
                AssetEmp assetEmp = (AssetEmp)list.get(0);
                return push(information,id,assetEmp.getName(),assetEmp.getSex(),assetEmp.getBirthday(),"资产科");
            case 12:
                LiaEmp liaEmp = (LiaEmp)list.get(0);
                return push(information,id,liaEmp.getName(),liaEmp.getSex(),liaEmp.getBirthday(),"负债科");
            case 13:
                MiddleEmp middleEmp = (MiddleEmp)list.get(0);
                return push(information,id,middleEmp.getName(),middleEmp.getSex(),middleEmp.getBirthday(),"中间科");
            case 14:
                PersonEmp personEmp = (PersonEmp)list.get(0);
                return push(information,id,personEmp.getName(),personEmp.getSex(),personEmp.getBirthday(),"个人科");
            default:
                Manager manager = (Manager)list.get(0);
                return push(information,id,manager.getName(),manager.getSex(),manager.getBirthday(),"领导");
        }
    }

    private static Information push(Information information,int id, String name, String sex, Date birthday,String room){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        information.setId(id);
        information.setBirthday(format.format(birthday));
        information.setName(name);
        information.setRoom(room);
        information.setSex(sex);
        return information;
    }
}
