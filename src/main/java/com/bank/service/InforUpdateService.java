package com.bank.service;

import java.util.Date;
import java.util.List;

public interface InforUpdateService {
    String passUpdate(int id,String pass);
    String infUpdate(int id, String name, String birthday,String sex);
    boolean CheckPass(int id,String pass);
    List inf_load(int id);
}
