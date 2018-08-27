package com.bank.dao;

import com.bank.bean.Login;

import java.util.Date;

public interface InfUpdateDao {
    String passUp(int id,String pass);
    String infUp(int id, String name, Date birthday, String sex);
    boolean CheckPass(int id,String pass);
}
