package com.bank.service.Impl;

import com.bank.bean.Perf;
import com.bank.bean.Performance;
import com.bank.dao.PerfDao;
import com.bank.service.PerfUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PerfUpServiceImpl implements PerfUpService {
    @Autowired
    public PerfUpServiceImpl(PerfDao perfDao) {
        this.perfDao = perfDao;
    }

    @Override
    @Transactional
    public String perfUp(Performance performance) {
        return perfDao.perfUp(performance);
    }

    @Override
    public Performance perfload(int id) {
            return perfDao.perfload(id / 1000 - 20);
    }

    @Override
    public Perf EmpPerfLoad(int id) {
        perfDao.updatePerf(id);
        return perfDao.empPerfLoad(id);
    }

    private final PerfDao perfDao;
}
