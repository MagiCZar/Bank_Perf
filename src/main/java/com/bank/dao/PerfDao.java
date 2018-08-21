package com.bank.dao;

import com.bank.bean.Performance;

public interface PerfDao {
    String updatePerf(int id);
    String perfUp(Performance performance);
}
