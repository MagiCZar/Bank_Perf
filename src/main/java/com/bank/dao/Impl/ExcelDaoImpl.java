package com.bank.dao.Impl;

import com.bank.bean.*;
import com.bank.dao.ExcelDao;
import com.bank.util.CriteriaUtil;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

/**
 * Created by CZ on 2018/8/5.
 */
@Repository("excelDao")
public class ExcelDaoImpl implements ExcelDao {
    @Autowired
    public ExcelDaoImpl(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public List update(List<List> list,int id) {
//        int id = Integer.parseInt(list.get(0).get(0).toString())/1000;
        Date date = new Date(Calendar.getInstance().getTimeInMillis());
            switch (id/1000){
                case 11:
                    for (List aList : list) {
                        AssetCus assetCus = new AssetCus();
                        assetCus.setCusId(Integer.parseInt(aList.get(0).toString()));
                        assetCus.setEmpId(Integer.parseInt(aList.get(0).toString())/1000);
                        assetCus.setCusName(aList.get(1).toString());
                        assetCus.setPhone(aList.get(2).toString());
                        assetCus.setNumber(Integer.parseInt(aList.get(3).toString()));
                        assetCus.setState(Byte.parseByte(aList.get(4).toString()));
                        assetCus.setUpday(date);
                        this.getHibernateTemplate().saveOrUpdate(assetCus);
                    }
                    DetachedCriteria assCus = DetachedCriteria.forClass(AssetCus.class);
                    assCus.add(Restrictions.eq("empId",id));
                    return this.getHibernateTemplate().findByCriteria(assCus);
                case 12:
                    for (List aList : list) {
                        LiaCus liaCus = new LiaCus();
                        liaCus.setCusId(Integer.parseInt(aList.get(0).toString()));
                        liaCus.setEmpId(Integer.parseInt(aList.get(0).toString())/1000);
                        liaCus.setCusName(aList.get(1).toString());
                        liaCus.setPhone(aList.get(2).toString());
                        liaCus.setNumber(Integer.parseInt(aList.get(3).toString()));
                        liaCus.setState(Byte.parseByte(aList.get(4).toString()));
                        liaCus.setUpday(date);
                        this.getHibernateTemplate().saveOrUpdate(liaCus);
                    }
                    DetachedCriteria liaCus = DetachedCriteria.forClass(LiaCus.class);
                    liaCus.add(Restrictions.eq("empId",id));
                    return this.getHibernateTemplate().findByCriteria(liaCus);
                case 13:
                    for (List aList : list) {
                        MiddleCus middleCus = new MiddleCus();
                        middleCus.setCusId(Integer.parseInt(aList.get(0).toString()));
                        middleCus.setEmpId(Integer.parseInt(aList.get(0).toString())/1000);
                        middleCus.setCusName(aList.get(1).toString());
                        middleCus.setPhone(aList.get(2).toString());
                        middleCus.setType(aList.get(3).toString());
                        middleCus.setNumber(Integer.parseInt(aList.get(4).toString()));
                        middleCus.setState(Byte.parseByte(aList.get(5).toString()));
                        middleCus.setUpday(date);
                        this.getHibernateTemplate().saveOrUpdate(middleCus);
                    }
                    DetachedCriteria midCus = DetachedCriteria.forClass(MiddleCus.class);
                    midCus.add(Restrictions.eq("empId",id));
                    return this.getHibernateTemplate().findByCriteria(midCus);
                case 14:
                    for (List aList : list) {
                        PersonCus personCus = new PersonCus();
                        personCus.setCusId(Integer.parseInt(aList.get(0).toString()));
                        personCus.setEmpId(Integer.parseInt(aList.get(0).toString())/1000);
                        personCus.setCusName(aList.get(1).toString());
                        personCus.setPhone(aList.get(2).toString());
                        personCus.setType(aList.get(3).toString());
                        personCus.setNumber(Integer.parseInt(aList.get(4).toString()));
                        personCus.setState(Byte.parseByte(aList.get(5).toString()));
                        personCus.setUpday(date);
                        this.getHibernateTemplate().saveOrUpdate(personCus);
                    }
                    DetachedCriteria perCus = DetachedCriteria.forClass(PersonCus.class);
                    perCus.add(Restrictions.eq("empId",id));
                    return this.getHibernateTemplate().findByCriteria(perCus);
                default:
                    return null;
            }
    }

    @Override
    public List load(int id) {
        DetachedCriteria criteria = CriteriaUtil.criteria(id);
        criteria.add(Restrictions.eq("empId",id));
        System.out.println(criteria);
        return this.getHibernateTemplate().findByCriteria(criteria);
    }


    private final HibernateTemplate hibernateTemplate;
    private HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }
}
