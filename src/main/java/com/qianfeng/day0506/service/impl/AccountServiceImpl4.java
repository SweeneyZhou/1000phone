package com.qianfeng.day0506.service.impl;

import com.qianfeng.JDBCUtils;
import com.qianfeng.day0506.service.AccountService;

public class AccountServiceImpl4 implements AccountService {
    @Override
    public boolean transfer(Integer fromId, Integer toId, Double money) {
        JDBCUtils.start();


        JDBCUtils.commit();
        return false;
    }

    @Override
    public boolean transfer2(Integer fromId, Integer toId, Double money) {
        return false;
    }

    @Override
    public boolean transfer3(Integer fromId, Integer toId, Double money) {
        return false;
    }
}
