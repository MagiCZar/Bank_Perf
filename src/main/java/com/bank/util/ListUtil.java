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
                    customer.setType("管户净增额");
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
                    customer.setType("对公存款");
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

    public static List<Emp> listTran(int id,List list){
        List<Emp> result = new ArrayList<>();
        switch (id/1000){
            case 21:
                for (Object aList : list) {
                    AssetEmp assetEmp = (AssetEmp) aList;
                    Emp emp = new Emp();
                    emp.setId(assetEmp.getId());
                    emp.setName(assetEmp.getName());
                    emp.setRoom("资产科");
                    emp.setPerform(assetEmp.getPerform());
                    emp.setAttendance(assetEmp.getAttendance());
                    result.add(emp);
                }
                break;
            case 22:
                for (Object aList : list) {
                    LiaEmp liaEmp = (LiaEmp)aList;
                    Emp emp = new Emp();
                    emp.setId(liaEmp.getId());
                    emp.setName(liaEmp.getName());
                    emp.setRoom("负债科");
                    emp.setPerform(liaEmp.getPerform());
                    emp.setAttendance(liaEmp.getAttendance());
                    result.add(emp);
                }
                break;
            case 23:
                for (Object aList : list) {
                    MiddleEmp middleEmp = (MiddleEmp)aList;
                    Emp emp = new Emp();
                    emp.setId(middleEmp.getId());
                    emp.setName(middleEmp.getName());
                    emp.setRoom("中间科");
                    emp.setPerform(middleEmp.getPerform());
                    emp.setAttendance(middleEmp.getAttendance());
                    result.add(emp);
                }
                break;
            case 24:
                for (Object aList : list) {
                    PersonEmp personEmp = (PersonEmp)aList;
                    Emp emp = new Emp();
                    emp.setId(personEmp.getId());
                    emp.setName(personEmp.getName());
                    emp.setRoom("个人科");
                    emp.setPerform(personEmp.getPerform());
                    emp.setAttendance(personEmp.getAttendance());
                    result.add(emp);
                }
                break;
        }
        return result;
    }

    public static List<Integer> perf(List list,int id){
        List<Integer> list1 = new ArrayList<>();
        switch (id/1000){
            case 11:
                AssetEmp assetEmp = (AssetEmp) list.get(0);
                list1.add(assetEmp.getLoan());
                list1.add(assetEmp.getAttendance());
                list1.add(assetEmp.getPerform());
                break;
            case 12:
                LiaEmp liaEmp = (LiaEmp)list.get(0);
                list1.add(liaEmp.getMaleDep());
                list1.add(liaEmp.getAttendance());
                list1.add(liaEmp.getPerform());
                break;
            case 14:
                PersonEmp personEmp = (PersonEmp)list.get(0);
                list1.add(personEmp.getPerdebt());
                list1.add(personEmp.getPerloan());
                list1.add(personEmp.getPerpay());
                list1.add(personEmp.getAgentserv());
                list1.add(personEmp.getAttendance());
                list1.add(personEmp.getPerform());
                break;
            case 13:
                MiddleEmp middleEmp = (MiddleEmp)list.get(0);
                list1.add(middleEmp.getFinancing());
                list1.add(middleEmp.getInvest());
                list1.add(middleEmp.getGuarantee());
                list1.add(middleEmp.getCash());
                list1.add(middleEmp.getAttendance());
                list1.add(middleEmp.getPerform());
                break;
        }
        return list1;
    }

    private static String state(byte state){
        if (state == 0){
            return "办理中";
        }else {
            return "已完成";
        }
    }


}
