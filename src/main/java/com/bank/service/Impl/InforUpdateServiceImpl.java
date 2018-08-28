package com.bank.service.Impl;

import com.bank.bean.Login;
import com.bank.dao.InfUpdateDao;
import com.bank.service.InforUpdateService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class InforUpdateServiceImpl implements InforUpdateService {
    @Autowired
    public InforUpdateServiceImpl(InfUpdateDao infUpdateDao) {
        this.infUpdateDao = infUpdateDao;
    }

    @Override
    @Transactional
    public String passUpdate(int id, String pass) {
        return infUpdateDao.passUp(id,pass);
    }

    @Override
    @Transactional
    public String infUpdate(int id, String name, String birth, String sex) {
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday;
        try {
            birthday = format1.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
            return "error!";
        }
        return infUpdateDao.infUp(id,name,birthday,sex);
    }

    @Override
    public boolean CheckPass(int id, String pass) {
        return infUpdateDao.CheckPass(id,pass);
    }

    @Override
    public List inf_load(int id) {
        return infUpdateDao.inf_load(id);
    }

    @Getter
    private final InfUpdateDao infUpdateDao;
}
