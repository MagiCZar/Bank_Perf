package com.bank.dao.Impl;

import com.bank.bean.*;
import com.bank.dao.InfUpdateDao;
import com.bank.util.CriteriaUtil;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository("infDao")
public class InfUpdateDaoImpl implements InfUpdateDao {

    private String message;

    @Autowired
    public InfUpdateDaoImpl(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    @Transactional
    public String passUp(int id, String pass) {
        Login login = this.getHibernateTemplate().get(Login.class,id);
        System.out.println(login.getPassword());
        login.setPassword(pass);
        try {
            this.getHibernateTemplate().update(login);
            message = "success！";
        }catch (Exception e){
            e.printStackTrace();
            message = "error！";
        }
        return message;
    }

    @Override
    @Transactional
    public String infUp(int id, String name, Date birthday, String sex) {
        java.sql.Date birth = new java.sql.Date(birthday.getTime());
        switch (id/1000){
            case 11:
                AssetEmp assetEmp = this.getHibernateTemplate().get(AssetEmp.class,id);
                assetEmp.setBirthday(birth);
                assetEmp.setSex(sex);
                assetEmp.setName(name);
                hiberup(assetEmp);
                break;
            case 12:
                LiaEmp liaEmp = new LiaEmp();
                liaEmp.setId(id);
                liaEmp.setBirthday(birth);
                liaEmp.setName(name);
                liaEmp.setSex(sex);
                hiberup(liaEmp);
                break;
            case 13:
                MiddleEmp middleEmp = new MiddleEmp();
                middleEmp.setId(id);
                middleEmp.setBirthday(birth);
                middleEmp.setName(name);
                middleEmp.setSex(sex);
                hiberup(middleEmp);
                break;
            case 14:
                PersonEmp personEmp = new PersonEmp();
                personEmp.setId(id);
                personEmp.setBirthday(birth);
                personEmp.setName(name);
                personEmp.setSex(sex);
                hiberup(personEmp);
                break;
            default:
                Manager manager = new Manager();
                manager.setId(id);
                manager.setBirthday(birth);
                manager.setName(name);
                manager.setSex(sex);
                hiberup(manager);
                break;
        }
        return message;
    }

    @Override
    public boolean CheckPass(int id, String pass) {
        Login login = this.hibernateTemplate.get(Login.class,id);
        return login.getPassword().equals(pass);
    }

    @Override
    public List inf_load(int id) {
        DetachedCriteria criteria = CriteriaUtil.Emp(id);
        criteria.add(Restrictions.eq("id",id));
        return this.getHibernateTemplate().findByCriteria(criteria);
    }

    private void hiberup(Object o){
        try {
            this.getHibernateTemplate().update(o);
            message = "success！";
        }catch (Exception e1){
            e1.printStackTrace();
            message = "failed！";
        }
    }

    @Getter
    private final HibernateTemplate hibernateTemplate;
}
