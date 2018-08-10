package com.bank.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.sql.Date;

/**
 * Created by CZ on 2018/8/8.
 */
@Entity
@IdClass(AttendancePK.class)
public class Attendance {
    private Date attDate;
    private int empId;

    @Id
    @Column(name = "attDate")
    public Date getAttDate() {
        return attDate;
    }

    public void setAttDate(Date attDate) {
        this.attDate = attDate;
    }

    @Id
    @Column(name = "empID")
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

        Attendance that = (Attendance) o;

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
