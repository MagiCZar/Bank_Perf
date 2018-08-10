package com.bank.bean;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by CZ on 2018/8/4.
 */
@Entity
@Table(name = "middle_emp", schema = "bankperf")
@DynamicInsert
public class MiddleEmp implements Serializable {
    private int id;
    private String name;
    private Date birthday;
    private String sex;
    private Integer perform;
    private Integer attendance;
    private Integer financing;
    private Integer invest;
    private Integer guarantee;
    private Integer cash;

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
    @Column(name = "financing")
    public Integer getFinancing() {
        return financing;
    }

    public void setFinancing(Integer financing) {
        this.financing = financing;
    }

    @Basic
    @Column(name = "invest")
    public Integer getInvest() {
        return invest;
    }

    public void setInvest(Integer invest) {
        this.invest = invest;
    }

    @Basic
    @Column(name = "guarantee")
    public Integer getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(Integer guarantee) {
        this.guarantee = guarantee;
    }

    @Basic
    @Column(name = "cash")
    public Integer getCash() {
        return cash;
    }

    public void setCash(Integer cash) {
        this.cash = cash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MiddleEmp middleEmp = (MiddleEmp) o;

        if (id != middleEmp.id) return false;
        if (name != null ? !name.equals(middleEmp.name) : middleEmp.name != null) return false;
        if (birthday != null ? !birthday.equals(middleEmp.birthday) : middleEmp.birthday != null) return false;
        if (sex != null ? !sex.equals(middleEmp.sex) : middleEmp.sex != null) return false;
        if (perform != null ? !perform.equals(middleEmp.perform) : middleEmp.perform != null) return false;
        if (attendance != null ? !attendance.equals(middleEmp.attendance) : middleEmp.attendance != null) return false;
        if (financing != null ? !financing.equals(middleEmp.financing) : middleEmp.financing != null) return false;
        if (invest != null ? !invest.equals(middleEmp.invest) : middleEmp.invest != null) return false;
        if (guarantee != null ? !guarantee.equals(middleEmp.guarantee) : middleEmp.guarantee != null) return false;
        if (cash != null ? !cash.equals(middleEmp.cash) : middleEmp.cash != null) return false;

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
        result = 31 * result + (financing != null ? financing.hashCode() : 0);
        result = 31 * result + (invest != null ? invest.hashCode() : 0);
        result = 31 * result + (guarantee != null ? guarantee.hashCode() : 0);
        result = 31 * result + (cash != null ? cash.hashCode() : 0);
        return result;
    }
}
