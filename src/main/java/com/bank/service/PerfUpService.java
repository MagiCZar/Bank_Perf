package com.bank.service;

import com.bank.bean.Perf;
import com.bank.bean.Performance;

import java.util.List;

public interface PerfUpService {
    String perfUp(Performance performance);
    Performance perfload(int id);
    Perf EmpPerfLoad(int id);
}
