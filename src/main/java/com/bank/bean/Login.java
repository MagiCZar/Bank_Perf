package com.bank.bean;

import javax.persistence.*;

/**
 * Created by CZ on 2018/8/2.
 */
@Entity
@Table(name = "user", schema = "bankperf")
public class Login {
    private int id;
    private String password;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Login userBean = (Login) o;

        if (id != userBean.id) return false;
        if (password != null ? !password.equals(userBean.password) : userBean.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
