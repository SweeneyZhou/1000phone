package com.qianfeng.day0322.homework;

import java.util.Arrays;

/*
 * 4、将一个int数组倒置
 * 方法二，交换数组下标
 * */
public class Test4_2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("将int数组" + Arrays.toString(arr) + "倒置后:");
        for (int i = 0; i < arr.length / 2; i++) {
            int t = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = t;
        }
        System.out.println(Arrays.toString(arr));
    }
}
