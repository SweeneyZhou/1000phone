package com.qianfeng.day0324.homework;

import java.util.Scanner;

/*
* 4.输入正方形的边长，返回周长
* */
public class Test4 {
    public static void main(String[] args) {
        System.out.println("请输入正方形的边长:");
        Scanner  scanner = new Scanner(System.in);
        double a= scanner.nextDouble();
        System.out.println("边长为"+a+"的正方形周长为:");
        System.out.println(getCircumference(a));
    }

    public static Double getCircumference(double a) {
        return 4*a;
    }
}
