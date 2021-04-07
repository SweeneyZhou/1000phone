package com.qianfeng.day0407.homework;
/*
* c.生成四位验证码，并判断输入是否成功
* */
import java.util.Random;
import java.util.Scanner;

public class Test3c {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String valid=getValid();
        System.out.println("请输入验证码:"+valid);
        String inputValid=scanner.next();
        if(inputValid.compareToIgnoreCase(valid)==0)
            System.out.println("验证成功！");
        else System.out.println("验证失败！");
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
