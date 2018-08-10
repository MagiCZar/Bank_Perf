package com.bank.bean;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by CZ on 2018/8/4.
 */
@Entity
@Table(name = "asset_emp", schema = "bankperf")
@DynamicInsert
public class AssetEmp implements Serializable {
    private int id;
    private String name;
    private Date birthday;
    private String sex;
    private Integer perform;
    private Integer attendance;
    private Integer loan;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "perform")
    public Integer getPerform() {
        return perform;
    }

    public void setPerform(Integer perform) {
        this.perform = perform;
    }

    @Basic
    @Column(name = "attendance")
    public Integer getAttendance() {
        return attendance;
    }

    public void setAttendance(Integer attendance) {
        this.attendance = attendance;
    }

    @Basic
    @Column(name = "loan")
    public Integer getLoan() {
        return loan;
    }

    public void setLoan(Integer loan) {
        this.loan = loan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AssetEmp assetEmp = (AssetEmp) o;

        if (id != assetEmp.id) return false;
        if (name != null ? !name.equals(assetEmp.name) : assetEmp.name != null) return false;
        if (birthday != null ? !birthday.equals(assetEmp.birthday) : assetEmp.birthday != null) return false;
        if (sex != null ? !sex.equals(assetEmp.sex) : assetEmp.sex != null) return false;
        if (perform != null ? !perform.equals(assetEmp.perform) : assetEmp.perform != null) return false;
        if (attendance != null ? !attendance.equals(assetEmp.attendance) : assetEmp.attendance != null) return false;
        if (loan != null ? !loan.equals(assetEmp.loan) : assetEmp.loan != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (perform != null ? perform.hashCode() : 0);
        result = 31 * result + (attendance != null ? attendance.hashCode() : 0);
        result = 31 * result + (loan != null ? loan.hashCode() : 0);
        return result;
    }
}
