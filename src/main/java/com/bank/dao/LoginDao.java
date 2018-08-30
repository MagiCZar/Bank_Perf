package com.bank.dao;

import com.bank.bean.Login;

import java.util.List;

/**
 * Created by CZ on 2018/8/2.
 */
public interface LoginDao {
    int check(Login user);
    void sign(int id);
    boolean perf(int id);
    List perflist(int id);
}
