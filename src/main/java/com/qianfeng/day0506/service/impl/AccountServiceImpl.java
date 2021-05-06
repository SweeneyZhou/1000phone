package com.qianfeng.day0506.service.impl;

import com.qianfeng.JDBCUtils;
import com.qianfeng.day0506.dao.AccountDAO;
import com.qianfeng.day0506.dao.impl.AccountDAOImpl;
import com.qianfeng.day0506.service.AccountService;

import java.sql.Connection;
import java.sql.SQLException;

public class AccountServiceImpl implements AccountService {
    AccountDAO accountDAO = new AccountDAOImpl();

    @Override
    public boolean transfer(Integer fromId, Integer toId, Double money) {
        try {
            boolean flag1 = accountDAO.minus(fromId, money);

            int c = 1 / 0;

            boolean flag2 = accountDAO.add(toId, money);
            return flag1 && flag2;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean transfer2(Integer fromId, Integer toId, Double money) {
        return accountDAO.transfer(fromId, toId, money);
    }

    @Override
    public boolean transfer3(Integer fromId, Integer toId, Double money) {
        try {
            Connection connection = JDBCUtils.getConnection();
            connection.setAutoCommit(false);
            boolean flag1 = accountDAO.minus(fromId, money, connection);

            boolean flag2 = accountDAO.add(toId, money, connection);
            if (flag1 && flag2) connection.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
