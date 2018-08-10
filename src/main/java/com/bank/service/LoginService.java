package com.bank.service;

import com.bank.bean.Login;

/**
 * Created by CZ on 2018/8/2.
 */
public interface LoginService {
    int login(Login user);
    void sign(int id);
}
