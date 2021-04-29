package com.qianfeng.day0331.homework;

public class Employee {
    private String name;
    private float salary;
    private int age;

    public Employee() {
    }

    public void doWork() {
        System.out.println("上班打卡");
    }

    public Employee(String name, float salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
