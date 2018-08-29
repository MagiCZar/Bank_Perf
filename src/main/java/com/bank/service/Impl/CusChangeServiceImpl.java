package com.bank.service.Impl;

import com.bank.dao.CusChangeDao;
import com.bank.service.CusChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CusChangeServiceImpl implements CusChangeService {
    @Autowired
    public CusChangeServiceImpl(CusChangeDao cusChangeDao) {
        this.cusChangeDao = cusChangeDao;
    }

    @Override
    @Transactional
    public String cusChange(int oldId, int newId) {
        if (oldId/1000 != newId/1000){
            return "illegal operation!";
        }else {
            return cusChangeDao.cusChange(oldId, newId);
        }
    }
    private final CusChangeDao cusChangeDao;
}
