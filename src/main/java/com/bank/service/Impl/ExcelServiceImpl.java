package com.bank.service.Impl;

import com.bank.dao.ExcelDao;
import com.bank.dao.PerfDao;
import com.bank.service.ExcelService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by CZ on 2018/8/5.
 */
@Service
public class ExcelServiceImpl implements ExcelService {
    @Autowired
    public ExcelServiceImpl(ExcelDao excelDao, PerfDao perfDao) {
        this.excelDao = excelDao;
        this.perfDao = perfDao;
    }

    //导入文件并写入数据库
    @Transactional
    @Override
    public List uplode(File file,int id) {
        List list;
        list = read(file,id);
        perfDao.updatePerf(id);
        if (list == null){
            return null;
        }else {
            return list;
        }

    }

    @Override
    public List load(int id) {
//        System.out.println(excelDao.load(id));
        return excelDao.load(id);
    }

    //读取文件
    private List read(File file,int id){
        List<List> list = new ArrayList<List>();
        String suffix = file.getName().substring(file.getName().lastIndexOf(".")+1);
        Workbook wb;
        try {
            InputStream is = new FileInputStream(file);
            if (suffix.equals("xls")){
                wb = new HSSFWorkbook(is);
            }else{
                wb = new XSSFWorkbook(is);
            }
            int numberOfSheets = wb.getNumberOfSheets();
            for (int i = 0 ; i < numberOfSheets ; i ++) {
                Sheet sheet = wb.getSheetAt(i);
                int rows = sheet.getPhysicalNumberOfRows();
                if(rows==0){
                    break;
                }
                Row row = sheet.getRow(0);
                int lcn = row.getLastCellNum();
                for (int j = 1 ;j < rows ; j++) {
                    List<String> sheetRow = new ArrayList<String>();
                    Row row1 = sheet.getRow(j);
                    getCellsValue(sheetRow,row1,lcn);
                    list.add(sheetRow);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return excelDao.update(list,id);
    }

//    获取单元格内的值
    public void getCellsValue (List<String> rows,Row row,int cellnumber) {
        for (int j = 0;j<cellnumber;j++) {
            Cell cell = row.getCell(j);
            if (!StringUtils.isEmpty(cell)) {
                switch (cell.getCellTypeEnum()) {
                    case STRING:
                        cell.setCellType(CellType.STRING);
                        rows.add(cell.getStringCellValue());
                        break;
                    case NUMERIC :
                        if (DateUtil.isCellDateFormatted(cell)) {
                            Date dateCellValue = cell.getDateCellValue();
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                            String format = simpleDateFormat.format(dateCellValue);
                            String todate = "to_date('"+format+"','YYYY-MM-DD HH24:MI:SS')";
                            rows.add(todate);
                        }else {
                            cell.setCellType(CellType.STRING);
                            rows.add(cell.getStringCellValue());
                        }
                        break;
                    default:cell.setCellType(CellType.STRING);
                        rows.add(cell.getStringCellValue());
                }

            } else {
                rows.add("");
            }
        }
    }

    private final ExcelDao excelDao;
    private final PerfDao perfDao;
}
