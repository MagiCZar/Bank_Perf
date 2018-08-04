package com.bank.controller;

import com.bank.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by CZ on 2018/8/3.
 */
@Controller
public class RegisterController {
    @RequestMapping("register")
    public void register(@RequestParam int id){
        register.add(id);
    }

    @Autowired
    private RegisterService register;
    public RegisterService getRegister() {
        return register;
    }
    public void setRegister(RegisterService register) {
        this.register = register;
    }
}
