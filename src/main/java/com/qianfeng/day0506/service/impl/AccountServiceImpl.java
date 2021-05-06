package com.qianfeng.day0506.service.impl;

import com.qianfeng.day0506.dao.AccountDAO;
import com.qianfeng.day0506.dao.impl.AccountDAOImpl;
import com.qianfeng.day0506.service.AccountService;

public class AccountServiceImpl implements AccountService {
    AccountDAO accountDAO = new AccountDAOImpl();

    @Override
    public boolean transfer(Integer fromId, Integer toId, Double money) {
        return accountDAO.minus(fromId, money) && accountDAO.add(toId, money);
    }
}
