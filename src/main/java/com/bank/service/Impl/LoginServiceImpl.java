package com.bank.service.Impl;

import com.bank.bean.Customer;
import com.bank.bean.Emp;
import com.bank.bean.Login;
import com.bank.dao.LoginDao;
import com.bank.service.LoginService;
import com.bank.util.ListUtil;
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
    public String perf(int id) {
        if (id<20000){
            if (userDao.perf(id)){
                return "1";
            }else {
                return "0";
            }
        }else {
            List<Emp> list = ListUtil.listTran(id,userDao.perflist(id));
            if (list.size()==0){
                return "0";
            }else {
                String mes = "";
                for (Emp emp : list) {
                    mes += emp.getId();
                    mes += "、";
                }
                return mes.substring(0,mes.length()-1);
            }
        }
    }

    private final LoginDao userDao;

}
