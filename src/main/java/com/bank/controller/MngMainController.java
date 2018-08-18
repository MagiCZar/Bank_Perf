package com.bank.controller;

import com.bank.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by CZ on 2018/8/3.
 */
@Controller
public class MngMainController {
    @RequestMapping("register")
    @ResponseBody
    public ModelAndView register(@RequestParam int id, ModelAndView model){
        int result = register.add(id);
        if (result != 0) {
            model.setViewName("WEB-INF/jsp/register");
            model.addObject("id",result);
            return model;
        }else {
            model.setViewName("WEB-INF/jsp/error");
            return model;
        }
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
