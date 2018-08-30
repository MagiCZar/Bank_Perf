package com.bank.controller;

import com.bank.bean.Emp;
import com.bank.bean.Information;
import com.bank.bean.Performance;
import com.bank.service.*;
import com.bank.util.InfTransUtil;
import com.bank.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by CZ on 2018/8/3.
 */
@Controller
@RequestMapping("/mng")
public class MngMainController {
    @Autowired
    public MngMainController(EmpLoadService empLoadService, RegisterService register, PerfUpService perfUpService, CusChangeService cusChangeService, InforUpdateService inforUpdateService) {
        this.empLoadService = empLoadService;
        this.register = register;
        this.perfUpService = perfUpService;
        this.cusChangeService = cusChangeService;
        this.inforUpdateService = inforUpdateService;
    }

    @RequestMapping("/register")
    @ResponseBody
    public String register(@RequestParam int id){
        return register.add(id);
    }

    @RequestMapping("/perfup")
    @ResponseBody
    public String perfup(@RequestBody Performance performance){
        return perfUpService.perfUp(performance);
    }

    @RequestMapping("/perfload")
    @ResponseBody
    public Performance perfload(@RequestParam int id){
        return perfUpService.perfload(id);
    }

    @RequestMapping("/cuschange")
    @ResponseBody
    public String perfup(@RequestParam int oldId,@RequestParam int newId){
        return cusChangeService.cusChange(oldId,newId);
    }

    @RequestMapping("/empload")
    @ResponseBody
    public List<Emp> empload(@RequestParam int id){
        return ListUtil.listTran(id,empLoadService.empLoad(id));
    }

    @RequestMapping("/infload")
    @ResponseBody
    public Information Infload(@RequestParam int id){
        return InfTransUtil.inf_trans(inforUpdateService.inf_load(id),id);
    }


    private final EmpLoadService empLoadService;
    private final RegisterService register;
    private final PerfUpService perfUpService;
    private final CusChangeService cusChangeService;
    private final InforUpdateService inforUpdateService;
}
