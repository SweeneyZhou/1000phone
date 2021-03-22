package com.qianfeng.day0322.homework;

import java.util.Arrays;

/*
 * 5、用数组打印斐波那契数列的前15项和第15项
 * */
public class Test5 {
    static final int N = 15;

    public static void main(String[] args) {
        int[] fab = new int[N];
        System.out.println("求斐波那契数列的前"+N+"项:");
        if(N==0) {
            System.out.println("[]");
            return;
        }else if(N==1){
            System.out.println("[1]");
            return;
        }
        fab[0] = 1;
        fab[1] = 1;
        for (int i = 2; i < N; i++) {
            fab[i] = fab[i - 2] + fab[i - 1];
        }
        System.out.println(Arrays.toString(fab));
        System.out.println("第"+N+"项为:"+fab[N-1]);
    }
}
