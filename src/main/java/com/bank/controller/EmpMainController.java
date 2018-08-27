package com.bank.controller;

import com.bank.bean.Customer;
import com.bank.service.ExcelService;
import com.bank.service.InforUpdateService;
import com.bank.util.ListUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by CZ on 2018/8/5.
 */
@Controller
@RequestMapping(value = "/success")
public class EmpMainController {
    @Autowired
    public EmpMainController(ExcelService excelService, InforUpdateService inforUpdateService) {
        this.excelService = excelService;
        this.inforUpdateService = inforUpdateService;
    }

    @RequestMapping(value = "/excel", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public List<Customer> Excel(@RequestParam(value = "file",required = false) MultipartFile file) throws IOException {
        List<Customer> list = new ArrayList<Customer>();
        if(file != null){
            int id = Integer.parseInt((Objects.requireNonNull(file.getOriginalFilename())).substring(0,5));
            System.out.println(id);
            File f = new File("D:/trans.xlsx");
            FileUtils.copyInputStreamToFile(file.getInputStream(),f);
            list = ListUtil.listTrans(id,excelService.uplode(f,id));
        }
        return list;
    }

    @RequestMapping("/passup")
    @ResponseBody
    public String PassUp(@RequestParam(value = "id",required = false) int id,
                         @RequestParam(value = "old",required = false)String old_pass,
                         @RequestParam(value = "new",required = false)String new_pass) {
        String message;
        if (inforUpdateService.CheckPass(id, old_pass)) {
            try {
                inforUpdateService.passUpdate(id,new_pass);
                message = "1";
            } catch (Exception e) {
                message = "failed";
            }
        }else {
            return "0";
    }
        return message;
    }


    private final ExcelService excelService;
    private final InforUpdateService inforUpdateService;
}
