package com.bank.dao.Impl;

import com.bank.bean.*;
import com.bank.dao.PerfDao;
import com.bank.util.CriteriaUtil;
import com.bank.util.PerfUtil;
import lombok.Getter;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Repository("PerfDao")
public class PerfDaoImpl implements PerfDao {
    @Autowired
    public PerfDaoImpl(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public String updatePerf(int id) {
        String message;
        byte state = 1;
        Performance performance;
        DetachedCriteria criteria = CriteriaUtil.criteria(id);
        criteria.add(Restrictions.eq("empId",id));
        criteria.add(Restrictions.eq("state",state));
        List list = this.getHibernateTemplate().findByCriteria(criteria);
        int num[] = PerfUtil.numCal(id,list);
        int perf;
        try {
            switch (id/1000){
                case 11:
                    AssetEmp assetEmp = this.getHibernateTemplate().get(AssetEmp.class,id);
                    performance = this.getHibernateTemplate().get(Performance.class,1);
                    perf = PerfUtil.perfCal(id,num, Objects.requireNonNull(assetEmp).getAttendance(),performance);
                    assetEmp.setPerform(perf);
                    assetEmp.setLoan(num[0]);
                    break;
                case 12:
                    LiaEmp liaEmp = this.getHibernateTemplate().get(LiaEmp.class,id);
                    performance = this.getHibernateTemplate().get(Performance.class,2);
                    perf = PerfUtil.perfCal(id,num, Objects.requireNonNull(liaEmp).getAttendance(),performance);
                    liaEmp.setPerform(perf);
                    liaEmp.setMaleDep(num[0]);
                    break;
                case 13:
                    MiddleEmp middleEmp = this.getHibernateTemplate().get(MiddleEmp.class,id);
                    performance = this.getHibernateTemplate().get(Performance.class,3);
                    perf = PerfUtil.perfCal(id,num, Objects.requireNonNull(middleEmp).getAttendance(),performance);
                    middleEmp.setPerform(perf);
                    middleEmp.setFinancing(num[0]);
                    middleEmp.setInvest(num[1]);
                    middleEmp.setGuarantee(num[2]);
                    middleEmp.setCash(num[3]);
                    break;
                case 14:
                    PersonEmp perEmp = this.getHibernateTemplate().get(PersonEmp.class,id);
                    performance = this.getHibernateTemplate().get(Performance.class,4);
                    perf = PerfUtil.perfCal(id,num, Objects.requireNonNull(perEmp).getAttendance(),performance);
                    perEmp.setPerform( perf);
                    perEmp.setPerdebt(num[0]);
                    perEmp.setPerloan(num[1]);
                    perEmp.setPerpay(num[2]);
                    perEmp.setAgentserv(num[3]);
                    break;
            }
            message =  "success";
        }catch (Exception e){
            message =  "failed";
        }
        return message;
    }

    @Override
    @Transactional
    public String perfUp(Performance performance) {
        String message;
        try {
            this.getHibernateTemplate().update(performance);
            message = "success";
        }catch (Exception e){
            e.printStackTrace();
            message = "error";
        }
        return message;
    }

    @Override
    public List perfLoad(int id) {
        DetachedCriteria criteria = CriteriaUtil.Emp(id);
        return this.getHibernateTemplate().findByCriteria(criteria);
    }

    @Override
    public Performance perfload(int id) {
        return this.getHibernateTemplate().get(Performance.class,id);
    }


    @Getter
    private final HibernateTemplate hibernateTemplate;
}
