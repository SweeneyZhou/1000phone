package com.qianfeng.day0319.homework;

import java.util.Scanner;

public class Test3_2 {
    static final String STOP = "xxx";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = "";
        String s1;
        do {
            s1 = scanner.next();
            s = s + s1;
        } while (!s1.contains(STOP));
        s = s.substring(0, s.indexOf(STOP) + 3);//输出xxx
        //s = s.substring(0, s.indexOf(STOP);//不输出xxx
        System.out.println("用户输入了:" + s);
    }
}
