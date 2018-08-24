package com.bank.dao.Impl;

import com.bank.bean.*;
import com.bank.dao.LoginDao;
import com.bank.util.CriteriaUtil;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

/**
 * Created by CZ on 2018/8/2.
 */
@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {
    @Autowired
    public LoginDaoImpl(SessionFactory sessionFactory, HibernateTemplate hibernateTemplate) {
        this.sessionFactory = sessionFactory;
        this.hibernateTemplate = hibernateTemplate;
    }

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

    @Override
    @Transactional
    public List cus(int id) {
        DetachedCriteria criteria;
        if (id > 10000 && id < 20000) {
            criteria = CriteriaUtil.criteria(id);
            criteria.add(Restrictions.eq("empId", id));
        }else {
            criteria = CriteriaUtil.criteria(id - 10000);
        }
        return this.getHibernateTemplate().findByCriteria(criteria);
    }

    @Getter
    private final SessionFactory sessionFactory;

    @Getter
    private final HibernateTemplate hibernateTemplate;
}
