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
    @Autowired
    public RegisterServiceImpl(RegisterDao registerDao) {
        this.registerDao = registerDao;
    }

    @Transactional
    @Override
    public int add(int id) {
        return registerDao.add(id);
    }

    @Override
    public String delete(int id) {
        return registerDao.delete(id);
    }

    private final RegisterDao registerDao;
}
