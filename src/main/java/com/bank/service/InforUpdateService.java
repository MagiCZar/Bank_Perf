package com.bank.service;

import java.util.Date;

public interface InforUpdateService {
    String passUpdate(int id,String pass);
    String infUpdate(int id, String name, Date birthday,String sex);
}
