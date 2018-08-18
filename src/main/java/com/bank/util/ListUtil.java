package com.bank.util;

import com.bank.bean.*;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {
    public static List<Customer> listTrans(int id, List list){
        List<Customer> result = new ArrayList<>();
        switch (id/1000){
            case 11:
                for (Object aList : list) {
                    AssetCus assetCus = (AssetCus) aList;
                    Customer customer = new Customer();
                    customer.setCusID(String.valueOf(assetCus.getCusId()));
                    customer.setCusName(assetCus.getCusName());
                    customer.setPhone(assetCus.getPhone());
                    customer.setType("");
                    customer.setMoney(String.valueOf(assetCus.getNumber()));
                    customer.setState(state(assetCus.getState()));
                    result.add(customer);
                }
                return result;
            case 12:
                for (Object aList : list) {
                    LiaCus liaCus = (LiaCus) aList;
                    Customer customer = new Customer();
                    customer.setCusID(String.valueOf(liaCus.getCusId()));
                    customer.setCusName(liaCus.getCusName());
                    customer.setPhone(liaCus.getPhone());
                    customer.setType("");
                    customer.setMoney(String.valueOf(liaCus.getNumber()));
                    customer.setState(state(liaCus.getState()));
                    result.add(customer);
                }
                return result;
            case 13:
                for (Object aList : list) {
                    MiddleCus middleCus = (MiddleCus) aList;
                    Customer customer = new Customer();
                    customer.setCusID(String.valueOf(middleCus.getCusId()));
                    customer.setCusName(middleCus.getCusName());
                    customer.setPhone(middleCus.getPhone());
                    customer.setType(middleCus.getType());
                    customer.setMoney(String.valueOf(middleCus.getNumber()));
                    customer.setState(state(middleCus.getState()));
                    result.add(customer);
                }
                return result;
            case 14:
                for (Object aList : list) {
                    PersonCus personCus = (PersonCus) aList;
                    Customer customer = new Customer();
                    customer.setCusID(String.valueOf(personCus.getCusId()));
                    customer.setCusName(personCus.getCusName());
                    customer.setPhone(personCus.getPhone());
                    customer.setType(personCus.getType());
                    customer.setMoney(String.valueOf(personCus.getNumber()));
                    customer.setState(state(personCus.getState()));
                    result.add(customer);
                }
                return result;
        }
        return result;
    }

    private static String state(byte state){
        if (state == 0){
            return "办理中";
        }else {
            return "已完成";
        }
    }
}
