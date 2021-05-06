package com.qianfeng.day0506.dao;

public interface AccountDAO {
    boolean add(Integer id, Double money);

    boolean minus(Integer id, Double money);
}
