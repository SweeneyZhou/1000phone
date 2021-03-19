package com.qianfeng.day0319;

import java.util.Scanner;

/*
 * 判断一个字符串是否是回文的
 * */
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                System.out.println("不是回文");
                return;
            }
        }
        System.out.println("是回文");
    }
}
