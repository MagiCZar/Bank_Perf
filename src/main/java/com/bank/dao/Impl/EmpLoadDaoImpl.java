package com.bank.dao.Impl;

import com.bank.bean.AssetEmp;
import com.bank.bean.LiaEmp;
import com.bank.bean.MiddleEmp;
import com.bank.bean.PersonEmp;
import com.bank.dao.EmpLoadDao;
import lombok.Getter;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("emploadDao")
public class EmpLoadDaoImpl implements EmpLoadDao {
    @Autowired
    public EmpLoadDaoImpl(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public List empLoad(int id) {
        DetachedCriteria criteria;
        switch (id/1000){
            case 21:
                criteria = DetachedCriteria.forClass(AssetEmp.class);
                return this.getHibernateTemplate().findByCriteria(criteria);
            case 22:
                criteria = DetachedCriteria.forClass(LiaEmp.class);
                return this.getHibernateTemplate().findByCriteria(criteria);
            case 23:
                criteria = DetachedCriteria.forClass(MiddleEmp.class);
                return this.getHibernateTemplate().findByCriteria(criteria);
            case 24:
                criteria = DetachedCriteria.forClass(PersonEmp.class);
                return this.getHibernateTemplate().findByCriteria(criteria);
        }
        return null;
    }

    @Getter
    private final HibernateTemplate hibernateTemplate;
}
