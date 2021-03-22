package com.qianfeng.day0320;

import java.util.Random;
import java.util.Scanner;

/*
 * 3、
 * 定义已有的用户名、密码、验证码、判断用户输入的用户名、密码、验证码是否正确，
 * 要求先单独判断验证码。
 * */
public class Test3 {
    static final String USERNAME = "sweeney";//用户名
    static final String PASSWORD = "88888888";//密码

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            String valid = getValidate();
            System.out.println("验证码:" + valid);
            System.out.println("请输入验证码：");
            String input_valid = scanner.nextLine();
            if (!valid.equals(input_valid)) {
                System.out.println("验证码错误！");
                continue;
            }
            System.out.println("请输入用户名：");
            String user = scanner.nextLine();
            System.out.println("请输入密码：");
            String pwd = scanner.nextLine();
            if (USERNAME.equals(user) && PASSWORD.equals(pwd)) {
                System.out.println("用户名密码正确！");
                return;
            } else {
                System.out.println("用户名密码错误！");
            }
        } while (true);
    }

    private static String getValidate() {

        Random random = new Random();
        String res = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder valid = new StringBuilder();
        for (int i = 0, len = res.length(); i < 4; i++) {
            valid.append(res.charAt(random.nextInt(len)));
        }
        return valid.toString();
    }
}
