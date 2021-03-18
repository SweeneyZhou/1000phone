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
        int total = scanner.nextInt();
        System.out.println("您需要付:");
        switch (total/1000){
            case 0:
                System.out.println(total+"元");break;
            case 1:
            case 2:
                System.out.println(total*0.95+"元");break;
            case 3:
            case 4:
                System.out.println(total*0.9+"元");break;
            default:
                System.out.println(total*0.8+"元");
        }
    }
}
