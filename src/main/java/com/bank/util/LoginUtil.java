package com.bank.util;

import com.bank.bean.Login;

/**
 * Created by CZ on 2018/8/3.
 */
public class LoginUtil {
    public Login pack(int id, String pass){
        Login user = new Login();
        user.setId(id);
        user.setPassword(pass);
        return user;
    }
}
