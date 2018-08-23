package com.bank.util;

import com.bank.bean.AssetCus;
import com.bank.bean.LiaCus;
import com.bank.bean.MiddleCus;
import com.bank.bean.PersonCus;
import org.hibernate.criterion.DetachedCriteria;

public class CriteriaUtil {
    public static DetachedCriteria criteria(int id){
        DetachedCriteria idcount;
        switch (id/1000){
            case 11:
                idcount = DetachedCriteria.forClass(AssetCus.class);
                break;
            case 12:
                idcount = DetachedCriteria.forClass(LiaCus.class);
                break;
            case 13:
                idcount = DetachedCriteria.forClass(MiddleCus.class);
                break;
            default:
                idcount = DetachedCriteria.forClass(PersonCus.class);
                break;
        }
        return idcount;
    }
}
