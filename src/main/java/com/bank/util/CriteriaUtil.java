package com.bank.util;

import com.bank.bean.*;
import org.hibernate.criterion.DetachedCriteria;

public class CriteriaUtil {
    public static DetachedCriteria criteria(int id){
        DetachedCriteria idCount;
        switch (id/1000){
            case 11:
                idCount = DetachedCriteria.forClass(AssetCus.class);
                break;
            case 12:
                idCount = DetachedCriteria.forClass(LiaCus.class);
                break;
            case 13:
                idCount = DetachedCriteria.forClass(MiddleCus.class);
                break;
            default:
                idCount = DetachedCriteria.forClass(PersonCus.class);
                break;
        }
        return idCount;
    }

    public static DetachedCriteria Emp(int id){
        DetachedCriteria idCount;
        switch (id/1000){
            case 11:
                idCount = DetachedCriteria.forClass(AssetEmp.class);
                break;
            case 12:
                idCount = DetachedCriteria.forClass(LiaEmp.class);
                break;
            case 13:
                idCount = DetachedCriteria.forClass(MiddleEmp.class);
                break;
            default:
                idCount = DetachedCriteria.forClass(PersonEmp.class);
                break;
        }
        return idCount;
    }
}
