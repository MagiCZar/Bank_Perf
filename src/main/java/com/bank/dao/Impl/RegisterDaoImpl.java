package com.bank.dao.Impl;

import com.bank.bean.Login;
import com.bank.dao.RegisterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by CZ on 2018/8/3.
 */
@Repository("registerDao")
public class RegisterDaoImpl implements RegisterDao {
    @Override
    public boolean add(int id) {
        Login login = new Login();
        login.setId(id);
        login.setPassword(Integer.toString(id));
        Employee employee = new Employee();
        employee.setId(id);
        hibernateTemplate.save(login);
        hibernateTemplate.save(employee);
        return false;
    }

    @Autowired
    private HibernateTemplate hibernateTemplate;
    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
