package com.bank.service.Impl;

import com.bank.bean.Login;
import com.bank.dao.InfUpdateDao;
import com.bank.service.InforUpdateService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class InforUpdateServiceImpl implements InforUpdateService {
    @Autowired
    public InforUpdateServiceImpl(InfUpdateDao infUpdateDao) {
        this.infUpdateDao = infUpdateDao;
    }

    @Override
    public String passUpdate(int id, String pass) {
        return infUpdateDao.passUp(id,pass);
    }

    @Override
    public String infUpdate(int id, String name, Date birthday, String sex) {
        return infUpdateDao.infUp(id,name,birthday,sex);
    }

    @Override
    public boolean CheckPass(int id, String pass) {
        return infUpdateDao.CheckPass(id,pass);
    }

    @Getter
    private final InfUpdateDao infUpdateDao;
}
