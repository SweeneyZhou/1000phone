package com.qianfeng.day0320;

import java.util.Scanner;

/*
 * 2、
 * 手动输入一串字符串，统计其中数字、字母、其他字符出现的个数
 *
 * 测试数据：asdf][';2398 1234[fds
 * */
public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count_num = 0, count_letter = 0, count_else = 0;
        String s = scanner.nextLine();
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9')
                count_num++;
            else if (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z')
                count_letter++;
            else
                count_else++;
        }
        System.out.println("数字的个数为:" + count_num);
        System.out.println("字母的个数为:" + count_letter);
        System.out.println("其他字符的个数为:" + count_else + "(含空格)");
    }
}
