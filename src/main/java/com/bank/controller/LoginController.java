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
//            model = new ModelAndView("redirect:/success");
            if (id > 10000 && id < 20000){
                loginService.sign(id);
                List<Customer> list = ListUtil.listTrans(id,loginService.cus(id));
                model.addObject("list",list);
                model.setViewName("EmpMainpage.jsp");
//                System.out.println(list);
            }else if (id > 20000 && id < 30000){

            }
            model.addObject("id",id);
//            System.out.println("\n \t提交表单\n");
            return model;
        }else {
            model.setViewName("login.jsp");
            model.addObject("error",ERROR);
            return model;
        }
    }

//    @RequestMapping("/success/{id}")
//    public ModelAndView success(@PathVariable String id,ModelAndView modelAndView){
//        modelAndView.setViewName("success");
//        modelAndView.addObject("id",id);
//        int uid = Integer.parseInt(id);
//        System.out.println(uid);
//        List<List<String>> list = ListUtil.listTrans(uid,loginService.cus(uid));
//        modelAndView.addObject("list",list);
//        return modelAndView;
//    }


    private final LoginService loginService;

}
