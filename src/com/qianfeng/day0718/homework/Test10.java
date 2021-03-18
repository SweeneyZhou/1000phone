package com.qianfeng.day0718.homework;

/*
 * 4.求1 1 2 3 5 8 13 21 ... 数列的第20项
 * */
public class Test10 {
    static final int N = 20;

    public static void main(String[] args) {
        int a = 1, b = 1;
        int i = 1;//a在第一项
        while (i < N) {//a在第N项时退出循环
            b = a + b;//b后移1位
            a = b - a;//a后移1位
            i++;//a项数+1
        }
        System.out.println(a);
    }
}
