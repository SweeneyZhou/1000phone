package com.qianfeng.day0320;

import java.util.Scanner;

/*
 * 4、
 * 定义银行卡密码，用户有3次机会输入密码，密码正确提示“欢迎”，
 * 密码错误提示“您还有n次机会”
 * */
public class Test4 {
    static final String PASSWORD = "012345";
    static final int COUNT = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < COUNT; i++) {
            System.out.println("请输入银行卡密码");
            String pwd = scanner.nextLine();
            if (PASSWORD.equals(pwd)) {
                System.out.println("欢迎~");
                return;
            } else {
                System.out.println("密码错误!您还有" + (COUNT - i - 1) + "次机会。");
            }
        }
        System.out.println("You have no chance！Reboot and get more chance.");
    }
}
