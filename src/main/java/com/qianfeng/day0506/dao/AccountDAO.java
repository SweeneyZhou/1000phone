package com.qianfeng.day0506.dao;

import java.sql.Connection;

public interface AccountDAO {
    boolean add(Integer id, Double money);

    boolean transfer(Integer fromId, Integer toId, Double money);

    boolean minus(Integer id, Double money);

    boolean add(Integer id, Double money, Connection connection);

    boolean minus(Integer id, Double money, Connection connection);
}
