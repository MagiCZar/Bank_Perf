package com.bank.dao;

import com.bank.bean.Performance;

import java.util.List;

public interface PerfDao {
    String updatePerf(int id);
    String perfUp(Performance performance);
    List perfLoad(int id);
}
