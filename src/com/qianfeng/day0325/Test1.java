package com.qianfeng.day0325;

import java.util.Random;
import java.util.Scanner;

public class Test1 {

    static final String USERNAME = "sweeney";//用户名
    static final String PASSWORD = "88888888";//密码

    public static void main(String[] args) {
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        String user, pwd;

        while (true) {
            System.out.println("请输入用户名:");
            user = scanner.next();
            System.out.println("请输入密码:");
            pwd = scanner.next();
            if (count < 3) {
                if (login(user, pwd)) {
                    System.out.println("登陆成功！欢迎~");
                    return;
                }
            } else {
                String valid = getValid();
                System.out.println("您已经第" + count + "次输入失败！");
                System.out.println("已为您生成验证码：" + valid);
                System.out.println("请输入验证码:");
                String valid_input = scanner.next();
                if (login(user, pwd, valid_input, valid)) {
                    System.out.println("登陆成功！欢迎~");
                    return;
                }
            }

            count++;
            System.out.println("登陆失败！请重新输入！");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }

    //    //private static boolean login(String... strings){
//        return false;
//    }
    private static boolean login(String user, String pwd) {
        return USERNAME.equals(user) && PASSWORD.equals(pwd);
    }

    private static boolean login(String user, String pwd, String valid_input, String valid) {
        if (valid.equals(valid_input)){
            return USERNAME.equals(user) && PASSWORD.equals(pwd);
        }else {
            System.out.println("验证码错误！");
        }
        return  false ;
    }

    private static String getValid() {
        Random random = new Random();
        String res = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int res_len = res.length();
        StringBuilder valid = new StringBuilder();
        for (int j = 0; j < 4; j++) {
            valid.append(res.charAt(random.nextInt(res_len)));
        }
        return valid.toString();
    }
}
