package com.bank.bean;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by CZ on 2018/8/8.
 */
@Entity
@Table(name = "asset_cus", schema = "bankperf")
public class AssetCus {
    private int cusId;
    private int empId;
    private String cusName;
    private String phone;
    private int number;
    private byte state;
    private Date upday;

    @Id
    @Column(name = "cusID")
    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    @Basic
    @Column(name = "empID")
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    @Basic
    @Column(name = "cusName")
    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "number")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Basic
    @Column(name = "state")
    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    @Basic
    @Column(name = "upday")
    public Date getUpday() {
        return upday;
    }

    public void setUpday(Date upday) {
        this.upday = upday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AssetCus assetCus = (AssetCus) o;

        if (cusId != assetCus.cusId) return false;
        if (empId != assetCus.empId) return false;
        if (number != assetCus.number) return false;
        if (state != assetCus.state) return false;
        if (cusName != null ? !cusName.equals(assetCus.cusName) : assetCus.cusName != null) return false;
        if (phone != null ? !phone.equals(assetCus.phone) : assetCus.phone != null) return false;
        if (upday != null ? !upday.equals(assetCus.upday) : assetCus.upday != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cusId;
        result = 31 * result + empId;
        result = 31 * result + (cusName != null ? cusName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + number;
        result = 31 * result + (int) state;
        result = 31 * result + (upday != null ? upday.hashCode() : 0);
        return result;
    }
}
