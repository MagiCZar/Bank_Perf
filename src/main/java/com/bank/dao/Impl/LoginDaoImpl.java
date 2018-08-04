package com.bank.dao.Impl;

import com.bank.bean.Login;
import com.bank.dao.LoginDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Created by CZ on 2018/8/2.
 */
@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
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
}
