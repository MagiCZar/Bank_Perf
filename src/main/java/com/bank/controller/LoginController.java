package com.bank.controller;

import com.bank.bean.Customer;
import com.bank.bean.Login;
import com.bank.service.LoginService;
import com.bank.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by CZ on 2018/8/2.
 */
@Controller
public class LoginController {
    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping("login")
    @ResponseBody
    public ModelAndView login(@RequestParam(value = "id")int id,
                              @RequestParam("password")String password,
                              ModelAndView model) {
        final String ERROR = "用户名或密码错误！";
        Login login = new Login();
        login.setId(id);
        login.setPassword(password);
        int result = loginService.login(login);
        if (result > 0){
            if (id > 10000 && id < 20000){
                loginService.sign(id);
                model.setViewName("EmpMainpage.jsp");
            }else {
                model.setViewName("MngMainpage.jsp");
            }
            model.addObject("perf",loginService.perf(id));
            model.addObject("id",id);
            return model;
        }else {
            model.setViewName("login.jsp");
            model.addObject("error",ERROR);
            return model;
        }
    }


    private final LoginService loginService;

}
