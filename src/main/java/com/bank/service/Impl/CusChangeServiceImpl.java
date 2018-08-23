package com.bank.service.Impl;

import com.bank.dao.CusChangeDao;
import com.bank.service.CusChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CusChangeServiceImpl implements CusChangeService {
    @Autowired
    public CusChangeServiceImpl(CusChangeDao cusChangeDao) {
        this.cusChangeDao = cusChangeDao;
    }

    @Override
    public String cusChange(int oldId, int newId) {
        return cusChangeDao.cusChange(oldId, newId);
    }

    private final CusChangeDao cusChangeDao;
}
