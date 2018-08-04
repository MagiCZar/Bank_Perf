package com.bank.controller;

import com.bank.bean.Login;
import com.bank.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by CZ on 2018/8/2.
 */
@Controller
public class LoginController {

    @RequestMapping("login")
    public String login(@RequestBody Login user) {
        int result = login.login(user);
        if (result > 0){
            return "success";
        }else {
            return "error";
        }
    }

    @Autowired
    private LoginService login;
    public LoginService getLogin(){
        return login;
    }
    public void setLogin(LoginService login){
        this.login = login;
    }

}
