package com.bank.bean;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by CZ on 2018/8/4.
 */
@Entity
@Table(name = "manager", schema = "bankperf")
public class Manager implements Serializable {
    private int id;
    private String name;
    private Date birthday;
    private String sex;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Manager manager = (Manager) o;

        if (id != manager.id) return false;
        if (name != null ? !name.equals(manager.name) : manager.name != null) return false;
        if (birthday != null ? !birthday.equals(manager.birthday) : manager.birthday != null) return false;
        if (sex != null ? !sex.equals(manager.sex) : manager.sex != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        return result;
    }
}
