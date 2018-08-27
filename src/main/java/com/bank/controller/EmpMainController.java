package com.bank.controller;

import com.bank.bean.Customer;
import com.bank.service.ExcelService;
import com.bank.service.InforUpdateService;
import com.bank.service.PerfUpService;
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
@RequestMapping(value = "/emp")
public class EmpMainController {
    @Autowired
    public EmpMainController(PerfUpService perfUpService, ExcelService excelService, InforUpdateService inforUpdateService) {
        this.perfUpService = perfUpService;
        this.excelService = excelService;
        this.inforUpdateService = inforUpdateService;
    }

    /**
        * @ TODO: 2018/8/27 导入文件
     */
    @RequestMapping(value = "/excel", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public List<Customer> Excel(@RequestParam(value = "file",required = false) MultipartFile file) throws IOException {
        List<Customer> list = new ArrayList<Customer>();
        System.out.println("begin");
        if(file != null){
            System.out.println("file");
            int id = Integer.parseInt((Objects.requireNonNull(file.getOriginalFilename())).substring(0,5));
            System.out.println(id);
            File f = new File("D:/trans.xlsx");
            FileUtils.copyInputStreamToFile(file.getInputStream(),f);
            list = ListUtil.listTrans(id,excelService.uplode(f,id));
        }
        return list;
    }

    /**
     * @ TODO: 2018/8/27 修改密码
     */
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

    /**
     * @ TODO: 2018/8/27 加载绩效
     */
    @RequestMapping("/perfload")
    @ResponseBody
    public List<Integer> PerfLoad(@RequestParam int id){
        return ListUtil.perf(perfUpService.perfLoad(id),id);
    }

    private final PerfUpService perfUpService;
    private final ExcelService excelService;
    private final InforUpdateService inforUpdateService;
}
