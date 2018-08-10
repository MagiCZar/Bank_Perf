package com.bank.bean;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by CZ on 2018/8/4.
 */
@Entity
@Table(name = "lia_emp", schema = "bankperf")
@DynamicInsert
public class LiaEmp implements Serializable {
    private int id;
    private String name;
    private Date birthday;
    private String sex;
    private Integer perform;
    private Integer attendance;
    private Integer maleDep;

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
    @Column(name = "male_dep")
    public Integer getMaleDep() {
        return maleDep;
    }

    public void setMaleDep(Integer maleDep) {
        this.maleDep = maleDep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LiaEmp liaEmp = (LiaEmp) o;

        if (id != liaEmp.id) return false;
        if (name != null ? !name.equals(liaEmp.name) : liaEmp.name != null) return false;
        if (birthday != null ? !birthday.equals(liaEmp.birthday) : liaEmp.birthday != null) return false;
        if (sex != null ? !sex.equals(liaEmp.sex) : liaEmp.sex != null) return false;
        if (perform != null ? !perform.equals(liaEmp.perform) : liaEmp.perform != null) return false;
        if (attendance != null ? !attendance.equals(liaEmp.attendance) : liaEmp.attendance != null) return false;
        if (maleDep != null ? !maleDep.equals(liaEmp.maleDep) : liaEmp.maleDep != null) return false;

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
        result = 31 * result + (maleDep != null ? maleDep.hashCode() : 0);
        return result;
    }
}
