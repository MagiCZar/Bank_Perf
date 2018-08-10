package com.bank.bean;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by CZ on 2018/8/4.
 */
@Entity
@Table(name = "person_emp", schema = "bankperf")
@DynamicInsert
public class PersonEmp implements Serializable {
    private int id;
    private String name;
    private Date birthday;
    private String sex;
    private Integer perform;
    private Integer attendance;
    private Integer perdebt;
    private Integer perloan;
    private Integer perpay;
    private Integer agentserv;

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
    @Column(name = "perdebt")
    public Integer getPerdebt() {
        return perdebt;
    }

    public void setPerdebt(Integer perdebt) {
        this.perdebt = perdebt;
    }

    @Basic
    @Column(name = "perloan")
    public Integer getPerloan() {
        return perloan;
    }

    public void setPerloan(Integer perloan) {
        this.perloan = perloan;
    }

    @Basic
    @Column(name = "perpay")
    public Integer getPerpay() {
        return perpay;
    }

    public void setPerpay(Integer perpay) {
        this.perpay = perpay;
    }

    @Basic
    @Column(name = "agentserv")
    public Integer getAgentserv() {
        return agentserv;
    }

    public void setAgentserv(Integer agentserv) {
        this.agentserv = agentserv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonEmp personEmp = (PersonEmp) o;

        if (id != personEmp.id) return false;
        if (name != null ? !name.equals(personEmp.name) : personEmp.name != null) return false;
        if (birthday != null ? !birthday.equals(personEmp.birthday) : personEmp.birthday != null) return false;
        if (sex != null ? !sex.equals(personEmp.sex) : personEmp.sex != null) return false;
        if (perform != null ? !perform.equals(personEmp.perform) : personEmp.perform != null) return false;
        if (attendance != null ? !attendance.equals(personEmp.attendance) : personEmp.attendance != null) return false;
        if (perdebt != null ? !perdebt.equals(personEmp.perdebt) : personEmp.perdebt != null) return false;
        if (perloan != null ? !perloan.equals(personEmp.perloan) : personEmp.perloan != null) return false;
        if (perpay != null ? !perpay.equals(personEmp.perpay) : personEmp.perpay != null) return false;
        if (agentserv != null ? !agentserv.equals(personEmp.agentserv) : personEmp.agentserv != null) return false;

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
        result = 31 * result + (perdebt != null ? perdebt.hashCode() : 0);
        result = 31 * result + (perloan != null ? perloan.hashCode() : 0);
        result = 31 * result + (perpay != null ? perpay.hashCode() : 0);
        result = 31 * result + (agentserv != null ? agentserv.hashCode() : 0);
        return result;
    }
}
