package com.bank.dao.Impl;

import com.bank.bean.*;
import com.bank.dao.PerfDao;
import com.bank.util.PerfUtil;
import lombok.Getter;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

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
        List list;
        Performance performance;
        int num[];
        int perf;
        byte state = 1;
        try {
            switch (id/1000){
                case 11:
                    AssetEmp assetEmp = this.getHibernateTemplate().get(AssetEmp.class,id);
                    DetachedCriteria assCus = DetachedCriteria.forClass(AssetCus.class);
                    assCus.add(Restrictions.eq("empId",id));
                    assCus.add(Restrictions.eq("state",state));
                    list = this.getHibernateTemplate().findByCriteria(assCus);
                    performance = this.getHibernateTemplate().get(Performance.class,1);
                    num = PerfUtil.numCal(id,list);
                    perf = PerfUtil.perfCal(id,num, Objects.requireNonNull(assetEmp).getAttendance(),performance);
                    assetEmp.setPerform(perf);
                    assetEmp.setLoan(num[0]);
                    break;
                case 12:
                    LiaEmp liaEmp = this.getHibernateTemplate().get(LiaEmp.class,id);
                    DetachedCriteria liaCus = DetachedCriteria.forClass(LiaCus.class);
                    liaCus.add(Restrictions.eq("empId",id));
                    liaCus.add(Restrictions.eq("state",state));
                    list = this.getHibernateTemplate().findByCriteria(liaCus);
                    performance = this.getHibernateTemplate().get(Performance.class,2);
                    num = PerfUtil.numCal(id,list);
                    perf = PerfUtil.perfCal(id,num, Objects.requireNonNull(liaEmp).getAttendance(),performance);
                    liaEmp.setPerform(perf);
                    liaEmp.setMaleDep(num[0]);
                    break;
                case 13:
                    MiddleEmp middleEmp = this.getHibernateTemplate().get(MiddleEmp.class,id);
                    DetachedCriteria midCus = DetachedCriteria.forClass(MiddleCus.class);
                    midCus.add(Restrictions.eq("empId",id));
                    midCus.add(Restrictions.eq("state",state));
                    list = this.getHibernateTemplate().findByCriteria(midCus);
                    performance = this.getHibernateTemplate().get(Performance.class,3);
                    num = PerfUtil.numCal(id,list);
                    perf = PerfUtil.perfCal(id,num, Objects.requireNonNull(middleEmp).getAttendance(),performance);
                    middleEmp.setPerform(perf);
                    middleEmp.setFinancing(num[0]);
                    middleEmp.setInvest(num[1]);
                    middleEmp.setGuarantee(num[2]);
                    middleEmp.setCash(num[3]);
                    break;
                case 14:
                    PersonEmp perEmp = this.getHibernateTemplate().get(PersonEmp.class,id);
                    DetachedCriteria perCus = DetachedCriteria.forClass(PersonCus.class);
                    perCus.add(Restrictions.eq("empId",id));
                    perCus.add(Restrictions.eq("state",state));
                    list = this.getHibernateTemplate().findByCriteria(perCus);
                    performance = this.getHibernateTemplate().get(Performance.class,4);
                    num = PerfUtil.numCal(id,list);
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
    public String perfUp(Performance performance) {
        String message;
        try {
            this.getHibernateTemplate().update(performance);
            message = "success";
        }catch (Exception e){
            message = "error";
        }
        return message;
    }


    @Getter
    private final HibernateTemplate hibernateTemplate;
}
