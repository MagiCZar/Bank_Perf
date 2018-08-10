package com.bank.controller;

import com.bank.bean.Login;
import com.bank.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by CZ on 2018/8/2.
 */
@Controller
public class LoginController {
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
            }
            model.setViewName("success");
            model.addObject("id",id);
            return model;
        }else {
            model.setViewName("login");
            model.addObject("error",ERROR);
            return model;
        }
    }


    @Autowired
    private LoginService loginService;
    public LoginService getLogin(){
        return loginService;
    }
    public void setLogin(LoginService loginService){
        this.loginService = loginService;
    }

}
