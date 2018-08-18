package com.bank.dao.Impl;

import com.bank.bean.*;
import com.bank.dao.LoginDao;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
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
        CriteriaBuilder crb = sessionFactory.getCurrentSession().getCriteriaBuilder();;
        switch (id/1000){
            case 11:
                CriteriaQuery<AssetCus> crqa=crb.createQuery(AssetCus.class);
                Root<AssetCus> roota=crqa.from(AssetCus.class);
                crqa.select(roota);
                crqa.where(crb.equal(roota.get("empId"),id));
                return sessionFactory.getCurrentSession().createQuery(crqa).getResultList();
            case 12:
                CriteriaQuery<LiaCus> crql=crb.createQuery(LiaCus.class);
                Root<LiaCus> rootl=crql.from(LiaCus.class);
                crql.select(rootl);
                crql.where(crb.equal(rootl.get("empId"),id));
                return sessionFactory.getCurrentSession().createQuery(crql).getResultList();
            case 13:
                CriteriaQuery<MiddleCus> crqm=crb.createQuery(MiddleCus.class);
                Root<MiddleCus> rootm=crqm.from(MiddleCus.class);
                crqm.select(rootm);
                crqm.where(crb.equal(rootm.get("empId"),id));
                return sessionFactory.getCurrentSession().createQuery(crqm).getResultList();
            case 14:
                CriteriaQuery<PersonCus> crqp=crb.createQuery(PersonCus.class);
                Root<PersonCus> rootp=crqp.from(PersonCus.class);
                crqp.select(rootp);
                crqp.where(crb.equal(rootp.get("empId"),id));
                return sessionFactory.getCurrentSession().createQuery(crqp).getResultList();
        }
        return null;
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
