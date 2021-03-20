package com.qianfeng.day0320;

import java.util.Scanner;

/*
 * 3、
 * 定义已有的用户名、密码、验证码、判断用户输入的用户名、密码、验证码是否正确，
 * 要求先单独判断验证码。
 * */
public class Test3 {
    static final String USERNAME = "sweeney";//用户名
    static final String PASSWORD = "88888888";//密码
    static final String VALIDATE = "case";//验证码

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入验证码：");
        String valid = scanner.nextLine();
        if (!VALIDATE.equals(valid)) {
            System.out.println("验证码错误！");
            return;
        }
        System.out.println("请输入用户名：");
        String user = scanner.nextLine();
        System.out.println("请输入密码：");
        String pwd = scanner.nextLine();
        if (USERNAME.equals(user) && PASSWORD.equals(pwd)) {
            System.out.println("用户名密码正确！");
        } else {
            System.out.println("用户名密码错误！");
        }
    }
}
