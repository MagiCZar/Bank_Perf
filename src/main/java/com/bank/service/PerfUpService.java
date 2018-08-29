package com.bank.service;

import com.bank.bean.Performance;

import java.util.List;

public interface PerfUpService {
    String perfUp(Performance performance);
    List perfLoad(int id);
    Performance perfload(int id);
}
