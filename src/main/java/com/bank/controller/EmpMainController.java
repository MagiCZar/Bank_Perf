package com.bank.controller;

import com.bank.service.ExcelService;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by CZ on 2018/8/5.
 */
@Controller
public class EmpMainController {
    @RequestMapping(value = "/success/excel", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView Excel(@RequestParam(value="file") MultipartFile file,
                              ModelAndView modelAndView) throws IOException {
//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
//            e.printStackTrace();
//        }
//        JFileChooser fileChooser = new JFileChooser();
//        fileChooser.setAcceptAllFileFilterUsed(false);
//        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
//        final String[][] fileENames = {
//                { ".xlsx", "Excel 2008 文件(*.xlsx)" },
//                { ".xls", "MS-Excel 2003 文件(*.xls)" }
//        };
//
//        // 显示所有文件
//        fileChooser.addChoosableFileFilter(new FileFilter() {
//
//            public boolean accept(File file) {
//                return true;
//            }
//
//            public String getDescription() {
//                return "所有文件(*.*)";
//            }
//        });
//        for (final String[] fileEName : fileENames) {
//            fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
//                public boolean accept(File file) {
//                    if (file.getName().endsWith(fileEName[0]) || file.isDirectory()) {
//                        return true;
//                    }
//                    return false;
//                }
//                public String getDescription() {
//                    return fileEName[1];
//                }
//            });
//        }
//        fileChooser.showOpenDialog(null);
//        File file = fileChooser.getSelectedFile();
        modelAndView.setViewName("success");
        if(!file.isEmpty()){
//            CommonsMultipartFile commonsmultipartfile = (CommonsMultipartFile) file;
//            DiskFileItem diskFileItem = (DiskFileItem) commonsmultipartfile.getFileItem();
//            File f = diskFileItem.getStoreLocation();
            File f = new File("D:/trans.xlsx");
            FileUtils.copyInputStreamToFile(file.getInputStream(),f);
            List list = excelService.uplode(f);
            modelAndView.addObject("list",list);
//            System.out.println("--------------------------------------");
//            System.out.println(list.size());
//            System.out.println("--------------------------------------");
//            System.out.println("转换之后的文件："+file);
        }
        return modelAndView;
    }


    @Autowired
    private ExcelService excelService;

    public ExcelService getExcelService() {
        return excelService;
    }

    public void setExcelService(ExcelService excelService) {
        this.excelService = excelService;
    }
}
