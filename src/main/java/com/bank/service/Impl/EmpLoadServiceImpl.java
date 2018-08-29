package com.bank.service.Impl;

import com.bank.dao.EmpLoadDao;
import com.bank.service.EmpLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpLoadServiceImpl implements EmpLoadService {
    private final EmpLoadDao empLoadDao;

    @Autowired
    public EmpLoadServiceImpl(EmpLoadDao empLoadDao) {
        this.empLoadDao = empLoadDao;
    }

    @Override
    public List empLoad(int id) {
        return empLoadDao.empLoad(id);
    }
}
