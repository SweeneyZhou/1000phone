package com.qianfeng.day0318.homework;

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
        main2();
        main3();
    }

    //b在第20项，b可以直接作为答案，不用再继续后面的计算
    public static void main2() {
        int a = 1, b = 1;
        int i = 2;//b在第2项
        while (i < N) {//b在第N项时退出循环
            b = a + b;//b后移1位
            a = b - a;//a后移1位
            i++;//项数+1
        }
        System.out.println(b);
    }

    //a和B在第18、19项时，第20项为a+b，不用在继续后面的计算
    public static void main3() {
        int a = 1, b = 1;
        int i = 3;//a+b在第3项
        while (i < N) {//第N项为a+b时退出循环
            b = a + b;//b后移1位
            a = b - a;//a后移1位
            i++;//项数+1
        }
        System.out.println(a + b);
    }
}
