package com.bank.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by CZ on 2018/8/8.
 */
public class AttendancePK implements Serializable {
    private Date attDate;
    private int empId;

    @Column(name = "attDate")
    @Id
    public Date getAttDate() {
        return attDate;
    }

    public void setAttDate(Date attDate) {
        this.attDate = attDate;
    }

    @Column(name = "empID")
    @Id
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AttendancePK that = (AttendancePK) o;

        if (empId != that.empId) return false;
        if (attDate != null ? !attDate.equals(that.attDate) : that.attDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = attDate != null ? attDate.hashCode() : 0;
        result = 31 * result + empId;
        return result;
    }
}
