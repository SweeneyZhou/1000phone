package com.qianfeng.day0331.homework;

public class Salesperson extends Employee {
    private float commission;

    public Salesperson() {
    }

    public Salesperson(String name, float salary, int age, float commission) {
        super(name, salary, age);
        this.commission = commission;
    }

    @Override
    public void doWork() {
        super.doWork();
        System.out.println("出门销售");
    }

    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }
}
