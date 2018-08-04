package com.bank.service.Impl;

import com.bank.bean.Login;
import com.bank.dao.LoginDao;
import com.bank.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by CZ on 2018/8/2.
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Transactional
    @Override
    public int login(Login user) {
        return userDao.check(user);
    }

    @Autowired
    private LoginDao userDao;

    public LoginDao setUserDao() {
        return userDao;
    }

    public void setUserDao(LoginDao userDao) {
        this.userDao = userDao;
    }

}
