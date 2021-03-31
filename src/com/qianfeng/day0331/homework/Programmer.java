package com.qianfeng.day0331.homework;

public class Programmer extends Employee {
    private float project_bonus;

    public Programmer() {
    }

    public Programmer(String name, float salary, int age, float project_bonus) {
        super(name, salary, age);
        this.project_bonus = project_bonus;
    }

    @Override
    public void doWork() {
        super.doWork();
        System.out.println("写bug");
    }

    public float getProject_bonus() {
        return project_bonus;
    }

    public void setProject_bonus(float project_bonus) {
        this.project_bonus = project_bonus;
    }
}
