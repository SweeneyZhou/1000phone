package com.qianfeng.day0319.homework;

import java.util.Scanner;

/*
 * 将用户输入的任意内容拼接成一段完整的内容，当用户输入“xxx”时结束，并输出这段话
 * */
public class Test3 {
    static final String STOP = "xxx";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        for (String s; ; ) {
            s = scanner.next();
            if (!s.contains(STOP)) {
                stringBuilder.append(s);
            } else {
                //s = s.substring(0, s.indexOf(STOP));//不输出xxx
                s = s.substring(0, s.indexOf(STOP)+3);//输出xxx
                stringBuilder.append(s);
                System.out.println("用户输入了:" + stringBuilder);
                return;
            }
        }
    }

}
