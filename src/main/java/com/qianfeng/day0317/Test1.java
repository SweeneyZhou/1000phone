package com.qianfeng.day0317;

import java.util.Scanner;

public class Test1 {
    static final String USERNAME="root";
    static final String PASSWORD="123456";
    static final String SUCCESS="登录成功!";
    static final String FAILED="登录失败!";
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username=sc.nextLine();
        System.out.println("请输入密码:");
        String password=sc.nextLine();
        if(USERNAME.equals(username)&&PASSWORD.equals(password))
            System.out.println(SUCCESS);
        else
            System.out.println(FAILED);
        System.out.println(USERNAME.equals(username)&&PASSWORD.equals(password)?SUCCESS:FAILED);
    }
}
