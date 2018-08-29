package com.bank.dao.Impl;

import com.bank.bean.AssetCus;
import com.bank.bean.LiaCus;
import com.bank.bean.MiddleCus;
import com.bank.bean.PersonCus;
import com.bank.dao.CusChangeDao;
import com.bank.util.CriteriaUtil;
import lombok.Getter;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("cusChange")
public class CusChangeDaoImpl implements CusChangeDao {
    @Autowired
    public CusChangeDaoImpl(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public String cusChange(int oldID, int newID) {
        String message;
        try {
            switch (oldID / 1000) {
                case 11:
                    DetachedCriteria assCus = DetachedCriteria.forClass(AssetCus.class);
                    assCus.add(Restrictions.eq("empId", oldID));
                    List list = this.getHibernateTemplate().findByCriteria(assCus);
                    for (Object alist : list) {
                        AssetCus assetCus = (AssetCus) alist;
                        this.getHibernateTemplate().delete(assetCus);
                        if (assetCus.getState()==0){
                            assetCus.setEmpId(newID);
                            assetCus.setCusId(usefulID(newID));
                            this.getHibernateTemplate().save(assetCus);
                        }
                    }
                    break;
                case 12:
                    DetachedCriteria lia = DetachedCriteria.forClass(LiaCus.class);
                    lia.add(Restrictions.eq("empId", oldID));
                    list = this.getHibernateTemplate().findByCriteria(lia);
                    for (Object alist : list) {
                        LiaCus liaCus = (LiaCus) alist;
                        this.getHibernateTemplate().delete(liaCus);
                        if (liaCus.getState()==0){
                            liaCus.setEmpId(newID);
                            liaCus.setCusId(usefulID(newID));
                            this.getHibernateTemplate().save(liaCus);
                        }
                    }
                    break;
                case 13:
                    DetachedCriteria mid = DetachedCriteria.forClass(MiddleCus.class);
                    mid.add(Restrictions.eq("empId", oldID));
                    list = this.getHibernateTemplate().findByCriteria(mid);
                    for (Object alist : list) {
                        MiddleCus midCus = (MiddleCus) alist;
                        this.getHibernateTemplate().delete(midCus);
                        if (midCus.getState()==0){
                            midCus.setEmpId(newID);
                            midCus.setCusId(usefulID(newID));
                            this.getHibernateTemplate().save(midCus);
                        }
                    }
                    break;
                case 14:
                    DetachedCriteria per = DetachedCriteria.forClass(PersonCus.class);
                    per.add(Restrictions.eq("empId", oldID));
                    list = this.getHibernateTemplate().findByCriteria(per);
                    for (Object alist : list) {
                        PersonCus personCus = (PersonCus) alist;
                        this.getHibernateTemplate().delete(personCus);
                        if (personCus.getState()==0){
                            personCus.setEmpId(newID);
                            personCus.setCusId(usefulID(newID));
                            this.getHibernateTemplate().save(personCus);
                        }
                    }
                    break;
            }
            message = "success";
        }catch (Exception e){
            e.getStackTrace();
            message = "failed";
        }
        return message;
    }

    private int usefulID(int id){
        DetachedCriteria idcount = CriteriaUtil.criteria(id);
        for (int i = 1;i < 9999;i++){
            int cid = id*10000 + i;
            idcount.add(Restrictions.eq("cusId",cid));
            List list = this.getHibernateTemplate().findByCriteria(idcount);
            if (list.size()==0){
                return id;
            }
        }
        return 0;
    }

    @Getter
    private final HibernateTemplate hibernateTemplate;
}
