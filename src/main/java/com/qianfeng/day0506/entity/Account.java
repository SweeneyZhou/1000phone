package com.qianfeng.day0506.entity;

public class Account {
    private Integer accountId;
    private String name;
    private Double money;

    public Account() {
    }

    public Account(Integer accountId, String name, Double money) {
        this.accountId = accountId;
        this.name = name;
        this.money = money;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
