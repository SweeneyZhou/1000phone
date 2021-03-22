package com.qianfeng.day0322.homework;

import java.util.Arrays;

/*
 * 4、将一个int数组倒置
 * */
public class Test4 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] a1 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            a1[arr.length - i - 1] = arr[i];
        }
        System.out.println("将int数组" + Arrays.toString(arr) + "倒置后:");
        System.out.println(Arrays.toString(a1));
    }
}
