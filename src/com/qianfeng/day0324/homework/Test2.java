package com.qianfeng.day0324.homework;

import java.util.Scanner;

/*
* 2.参数是int和String，要求根据指定int，返回String上的字符
* */
public class Test2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入字符串:");
        String s=scanner.nextLine();
        System.out.println("请输入int:");
        int a=scanner.nextInt();
        System.out.println("在"+s+"中第"+a+"个字符为:");
        System.out.println(getCharInString(s,--a));
    }
    public static char getCharInString(String s,int i){
         return s.charAt(i);
    }
}
