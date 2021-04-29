package com.qianfeng.day0317.homework;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int o=scanner.nextInt();
        if(o%2==0){
            System.out.println("是偶数");
        }else {
            System.out.println("是奇数");
        }
        scanner.close();
    }
}
