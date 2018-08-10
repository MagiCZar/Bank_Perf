package com.bank.bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by CZ on 2018/8/8.
 */
@Entity
public class Performance {
    private int room;
    private double perf1;
    private double perf2;
    private double perf3;
    private double perf4;
    private double attendence;
    private double score;
    private Date testdate;

    @Id
    @Column(name = "room")
    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    @Basic
    @Column(name = "perf1")
    public double getPerf1() {
        return perf1;
    }

    public void setPerf1(double perf1) {
        this.perf1 = perf1;
    }

    @Basic
    @Column(name = "perf2")
    public double getPerf2() {
        return perf2;
    }

    public void setPerf2(double perf2) {
        this.perf2 = perf2;
    }

    @Basic
    @Column(name = "perf3")
    public double getPerf3() {
        return perf3;
    }

    public void setPerf3(double perf3) {
        this.perf3 = perf3;
    }

    @Basic
    @Column(name = "perf4")
    public double getPerf4() {
        return perf4;
    }

    public void setPerf4(double perf4) {
        this.perf4 = perf4;
    }

    @Basic
    @Column(name = "attendence")
    public double getAttendence() {
        return attendence;
    }

    public void setAttendence(double attendence) {
        this.attendence = attendence;
    }

    @Basic
    @Column(name = "score")
    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Basic
    @Column(name = "testdate")
    public Date getTestdate() {
        return testdate;
    }

    public void setTestdate(Date testdate) {
        this.testdate = testdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Performance that = (Performance) o;

        if (room != that.room) return false;
        if (Double.compare(that.perf1, perf1) != 0) return false;
        if (Double.compare(that.perf2, perf2) != 0) return false;
        if (Double.compare(that.perf3, perf3) != 0) return false;
        if (Double.compare(that.perf4, perf4) != 0) return false;
        if (Double.compare(that.attendence, attendence) != 0) return false;
        if (Double.compare(that.score, score) != 0) return false;
        if (testdate != null ? !testdate.equals(that.testdate) : that.testdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = room;
        temp = Double.doubleToLongBits(perf1);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(perf2);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(perf3);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(perf4);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(attendence);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(score);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (testdate != null ? testdate.hashCode() : 0);
        return result;
    }
}
