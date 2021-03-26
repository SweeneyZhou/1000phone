package com.qianfeng.day0326.homework;

import java.util.Scanner;

/*
 * 1.判断用户输入的是否是手机号（1开头，11位的纯数字）
 * */
public class Test1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String reg = "^1[0-9]{10}";

        if (s.matches(reg)) {
            System.out.println("是手机号");
        } else
            System.out.println("不是手机号");

        if (checkPhone(s)) {
            System.out.println("是手机号");
        } else
            System.out.println("不是手机号");
    }

    private static boolean checkPhone(String s) {
        return check11(s) && check1(s);
    }

    private static boolean check11(String s) {
        if (s.length() != 11) return false;
        for (int i = 0; i < 11; i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') return false;
        }
        return true;
    }

    private static boolean check1(String s) {
        return s.charAt(0) == '1';
    }


}
