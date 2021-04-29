package com.qianfeng.day0408.homework;

import java.util.ArrayList;
import java.util.Arrays;

/*
* 5.定义Emp的ArrayList集合，
每个员工对象有若干属性（自定义），
输出所有员工的所有信息
* */
public class Test5 {
    public static void main(String[] args) {
        Emp[] empArray=new Emp[]{
                new Emp("张三",24,14456),
                new Emp("李四",27,17423),
                new Emp("王五",23,16452)
        };
        ArrayList<Emp> empArrayList = new ArrayList<>(Arrays.asList(empArray));
        System.out.println(empArrayList);
    }
}
class Emp{
    private String name;
    private int age;
    private float salary;

    public Emp(String name, int age, float salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "{" +
                " 姓名:" + name +
                ", 年龄:" + age +
                ", 薪资:" + salary +
                '}';
    }
}
