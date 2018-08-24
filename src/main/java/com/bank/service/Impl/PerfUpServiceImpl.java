package com.bank.service.Impl;

import com.bank.bean.Performance;
import com.bank.dao.PerfDao;
import com.bank.service.PerfUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfUpServiceImpl implements PerfUpService {
    @Autowired
    public PerfUpServiceImpl(PerfDao perfDao) {
        this.perfDao = perfDao;
    }

    @Override
    public String perfUp(Performance performance) {
        return perfDao.perfUp(performance);
    }

    private final PerfDao perfDao;
}
