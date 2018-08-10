package com.bank.dao.Impl;

import com.bank.bean.Attendance;
import com.bank.bean.Login;
import com.bank.dao.LoginDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.util.Calendar;

/**
 * Created by CZ on 2018/8/2.
 */
@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {
    @Transactional
    @Override
    public int check(Login user) {
        //这里使用JPA规范的CriteriaQuery
        CriteriaBuilder crb = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Login> crq=crb.createQuery(Login.class);
        Root<Login> root=crq.from(Login.class);
        crq.select(root);
        crq.where(crb.equal(root.get("id"),user.getId()),crb.equal(root.get("password"),user.getPassword()));
        return sessionFactory.getCurrentSession().createQuery(crq).getResultList().size();
    }

    @Override
    @Transactional
    public void sign(int id) {
        Date date = new Date(Calendar.getInstance().getTimeInMillis());
        Attendance attendance = new Attendance();
        attendance.setEmpId(id);
        attendance.setAttDate(date);
        this.getSessionFactory().getCurrentSession().saveOrUpdate(attendance);
    }

    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
