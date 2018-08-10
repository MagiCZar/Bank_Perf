package com.bank.dao.Impl;

import com.bank.bean.*;
import com.bank.dao.RegisterDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by CZ on 2018/8/3.
 */
@Repository("registerDao")
public class RegisterDaoImpl implements RegisterDao {
    @Override
    public int add(int frontid) {

        if (frontid > 0 && frontid < 5) {
            int id = usefulID(frontid);
            if (id != 0) {
                Login login = new Login();
                login.setId(id);
                login.setPassword(Integer.toString(id));
                this.getHibernateTemplate().save(login);
            }
            switch (frontid){
                case 1 :
                    AssetEmp emp1 = new AssetEmp();
                    emp1.setId(id);
                    this.getHibernateTemplate().save(emp1);
                    break;
                case 2 :
                    LiaEmp emp2 = new LiaEmp();
                    emp2.setId(id);
                    this.getHibernateTemplate().save(emp2);
                    break;
                case 3 :
                    MiddleEmp emp3 = new MiddleEmp();
                    emp3.setId(id);
                    this.getHibernateTemplate().save(emp3);
                    break;
                case 4 :
                    PersonEmp emp4 = new PersonEmp();
                    emp4.setId(id);
                    this.getHibernateTemplate().save(emp4);
                    break;
                default:
                    break;
            }
            return id;
        }
        return 0;
    }

    private int usefulID(int frontid){
        for (int i = 1;i < 1000;i++){
            int id = 10000 + frontid*1000 + i;
            DetachedCriteria idcount = DetachedCriteria.forClass(Login.class);
            idcount.add(Restrictions.eq("id",id));
            List list = this.getHibernateTemplate().findByCriteria(idcount);
            if (list.size()==0){
                return id;
            }
        }
        return 0;
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
