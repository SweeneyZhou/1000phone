package com.qianfeng.day0718.homework;

import java.util.Scanner;

/*
*   商场买东西打折问题
*   >1000 打95折
*   >3000 打9折
*   >5000 打8折
*   输入金额，计算付的钱
* */
public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入金额:");
        double total = scanner.nextDouble();
        System.out.println("您需要付:");
        if (total>5000){
            System.out.println(total*.8+"元");
        }else if(total>3000){
            System.out.println(total*.9+"元");
        }else if (total>1000){
            System.out.println(total*.95+"元");
        }else System.out.println(total+"元");
    }
}
