package com.qianfeng.day0319.homework;

/*
 * 计算1~10000以内，每一位的4次方之和等于自身的数（类似于水仙花数）
 * */
public class Test2 {
    public static final int NUM = 10000;

    public static void main(String[] args) {
        for (int i = 1; i <= NUM; i++) {
            int sum = 0;
            int temp = i;
            while (temp != 0) {
                sum += (temp % 10) * (temp % 10) * (temp % 10) * (temp % 10);
                temp /= 10;
            }
            if (sum == i) System.out.println(i);
        }
    }
}
