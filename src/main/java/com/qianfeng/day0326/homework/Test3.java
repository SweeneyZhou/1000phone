package com.qianfeng.day0326.homework;

import java.util.Scanner;

/*
 * 3.输入一个字符串，输入一个字符，返回这个字符在字符串中出现的个数
 * */
public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char c = scanner.next().charAt(0);
        System.out.println("字符'" + c + "'在字符串\"" + s + "\"中的个数为:");
        System.out.println(countChar(s, c));
    }

    public static int countChar(String s, char c) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (c == s.charAt(i)) count++;
        }

        return count;
    }
}
