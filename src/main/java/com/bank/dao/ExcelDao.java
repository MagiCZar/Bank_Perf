package com.bank.dao;

import java.util.List;

/**
 * Created by CZ on 2018/8/5.
 */
public interface ExcelDao {
    List update(List<List> list,int id);
    List load(int id);
}
