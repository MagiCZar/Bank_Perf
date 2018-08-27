package com.bank.dao.Impl;

import com.bank.bean.*;
import com.bank.dao.InfUpdateDao;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository("infDao")
public class InfUpdateDaoImpl implements InfUpdateDao {

    private String message;

    @Autowired
    public InfUpdateDaoImpl(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public String passUp(int id, String pass) {

        Login login = new Login();
        login.setId(id);
        login.setPassword(pass);
        try {
            this.getHibernateTemplate().update(login);
            message = "密码修改成功！";
        }catch (Exception e){
            message = "密码修改失败！";
        }
        return message;
    }

    @Override
    public String infUp(int id, String name, Date birthday, String sex) {
        java.sql.Date birth = new java.sql.Date(birthday.getTime());
        switch (id/1000){
            case 11:
                AssetEmp assetEmp = new AssetEmp();
                assetEmp.setId(id);
                assetEmp.setBirthday(birth);
                assetEmp.setSex(sex);
                assetEmp.setName(name);
                try {
                    this.getHibernateTemplate().update(assetEmp);
                    message = "个人信息更新成功！";
                }catch (Exception e1){
                    message = "个人信息更新失败！";
                }
                break;
            case 12:
                LiaEmp liaEmp = new LiaEmp();
                liaEmp.setId(id);
                liaEmp.setBirthday(birth);
                liaEmp.setName(name);
                liaEmp.setSex(sex);
                try {
                    this.getHibernateTemplate().update(liaEmp);
                    message = "个人信息更新成功！";
                }catch (Exception e1){
                    message = "个人信息更新失败！";
                }
                break;
            case 13:
                MiddleEmp middleEmp = new MiddleEmp();
                middleEmp.setId(id);
                middleEmp.setBirthday(birth);
                middleEmp.setName(name);
                middleEmp.setSex(sex);
                try {
                    this.getHibernateTemplate().update(middleEmp);
                    message = "个人信息更新成功！";
                }catch (Exception e1){
                    message = "个人信息更新失败！";
                }
                break;
            case 14:
                PersonEmp personEmp = new PersonEmp();
                personEmp.setId(id);
                personEmp.setBirthday(birth);
                personEmp.setName(name);
                personEmp.setSex(sex);
                try {
                    this.getHibernateTemplate().update(personEmp);
                    message = "个人信息更新成功！";
                }catch (Exception e1){
                    message = "个人信息更新失败！";
                }
                break;
            default:
                Manager manager = new Manager();
                manager.setId(id);
                manager.setBirthday(birth);
                manager.setName(name);
                manager.setSex(sex);
                try {
                    this.getHibernateTemplate().update(manager);
                    message = "个人信息更新成功！";
                }catch (Exception e1){
                    message = "个人信息更新失败！";
                }
                break;
        }
        return message;
    }

    @Override
    public boolean CheckPass(int id, String pass) {
        Login login = this.hibernateTemplate.get(Login.class,id);
        return login.getPassword().equals(pass);
    }


    @Getter
    private final HibernateTemplate hibernateTemplate;
}
