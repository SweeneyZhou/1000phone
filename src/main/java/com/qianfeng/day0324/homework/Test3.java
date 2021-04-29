package com.qianfeng.day0324.homework;

import java.util.Scanner;

/*
* 3.输入圆的半径，返回面积
* */
public class Test3 {
    public static void main(String[] args) {
        System.out.println("输入圆的半径:");
        Scanner scanner =new Scanner(System.in);
        double r= scanner.nextDouble();
        System.out.println("返回面积:");
        System.out.println(getArea(r));
    }

    private static double getArea(double r) {
        return Math.PI*r*r;
    }
}
