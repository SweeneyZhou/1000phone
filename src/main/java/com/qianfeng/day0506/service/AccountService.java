package com.qianfeng.day0506.service;

public interface AccountService {
    boolean transfer(Integer fromId, Integer toId, Double money);
}
