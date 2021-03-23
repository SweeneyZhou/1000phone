package com.qianfeng.day0323.homework;

import java.util.Arrays;
import java.util.Random;

/*
 * 4.将一个nextInt(9)+1的随机数赋值给一个长度为9的int数组，保证不能重复
 * */
public class Test4 {
    public static void main(String[] args) {
        int[] a = new int[9];
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            int t = random.nextInt(9) + 1;
            a[i] = t;
            for (int j = 0; j < i; j++) {
                if (a[j] == t) {
                    a[i] = 0;
                    i--;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
