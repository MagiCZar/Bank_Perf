package com.bank.service.Impl;

import com.bank.dao.RegisterDao;
import com.bank.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by CZ on 2018/8/3.
 */
@Service("registerService")
public class RegisterServiceImpl implements RegisterService {
    @Transactional
    @Override
    public boolean add(int id) {
        return registerDao.add(id);
    }

    @Autowired
    private RegisterDao registerDao;
    public RegisterDao getRegisterDao() {
        return registerDao;
    }
    public void setRegisterDao(RegisterDao registerDao) {
        this.registerDao = registerDao;
    }
}
