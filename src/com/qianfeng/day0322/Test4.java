package com.qianfeng.day0322;

import java.util.Scanner;

/*
 * 3、
 * 用户通过键盘输入任意内容，拼接成一句语句，当输入！时，将这句话输出
 * 当用户输入x时，将用书输入的所有内容输出
 * */
public class Test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder str = new StringBuilder();
        String s1,s2="";


        for (;;){
            System.out.println("请输入：");
            s1 = scanner.nextLine();
            if ("x".equals(s1)) {
                System.out.println(s2);
            } else if ("!".equals(s1)) {
                System.out.println(str);
                s2="";
                str = new StringBuilder();
            } else {
                s2=s1;
                str.append(s2).append("\n");
            }
        }
    }
}
