package com.qianfeng.day0317.homework;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int year=scanner.nextInt();
        if (year%4==0&&year%100!=0||year%400==0){
            System.out.println("是闰年");
        }else{
            System.out.println("是平年");
        }
        scanner.close();
    }
}
