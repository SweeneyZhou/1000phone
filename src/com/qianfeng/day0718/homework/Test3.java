package com.qianfeng.day0718.homework;

import java.util.Scanner;

/*
* 输入年月日，输出是该年的第几天
* */
public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年月日以空格键隔开:");
        int sum=0;
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        switch (month-1){
            case 11:sum+=30;
            case 10:sum+=31;
            case 9:sum+=30;
            case 8:sum+=31;
            case 7:sum+=31;
            case 6:sum+=30;
            case 5:sum+=31;
            case 4:sum+=30;
            case 3:sum+=31;
            case 2:
                sum+=(year%4==0&&year%100!=0||year%400==0)?29:28;
            case 1:sum+=31;
            case 0:sum+=day;break;
            default:
                System.out.println("月份错误！");
                return;
        }
        System.out.println("这一年已经过去了"+sum+"天.");
    }
}
