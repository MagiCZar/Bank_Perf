package com.bank.dao;

import java.util.Date;

public interface InfUpdateDao {
    String passUp(int id,String pass);
    String infUp(int id, String name, Date birthday, String sex);
}
