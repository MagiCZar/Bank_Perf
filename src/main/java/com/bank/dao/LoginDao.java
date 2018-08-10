package com.bank.dao;

import com.bank.bean.Login;

/**
 * Created by CZ on 2018/8/2.
 */
public interface LoginDao {
    int check(Login user);
    void sign(int id);
}
