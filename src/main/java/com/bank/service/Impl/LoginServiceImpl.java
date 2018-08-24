package com.bank.service.Impl;

import com.bank.bean.Login;
import com.bank.dao.LoginDao;
import com.bank.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CZ on 2018/8/2.
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    public LoginServiceImpl(LoginDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public int login(Login user) {
        return userDao.check(user);
    }

    @Override
    @Transactional
    public void sign(int id) {
        userDao.sign(id);
    }

    @Override
    @Transactional
    public List cus(int id) {
        return userDao.cus(id);
    }

    private final LoginDao userDao;

}
