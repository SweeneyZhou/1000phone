package com.qianfeng.day0318.homework;

import java.util.Scanner;

/*
 *   输入月份，输出季节
 *
 * */
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入月份");
        String month = scanner.next();
        switch (month) {
            case "3":
            case "4":
            case "5":
                System.out.println("春天");
                break;
            case "6":
            case "7":
            case "8":
                System.out.println("夏天");
                break;
            case "9":
            case "10":
            case "11":
                System.out.println("秋天");
                break;
            case "12":
            case "1":
            case "2":
                System.out.println("冬天");
                break;
            default:
                System.out.println("您的输入有误！");
        }
    }
}
