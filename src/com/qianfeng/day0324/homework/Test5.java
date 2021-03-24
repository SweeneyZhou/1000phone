package com.qianfeng.day0324.homework;

import java.util.Arrays;

/*
 * 5.参数是int数组，返回数组中的最大值
 * */
public class Test5 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 73, 43, 53, 123, 5, 853, 56};
        System.out.println("在数组" + Arrays.toString(arr) + "中的最大值为:");
        System.out.println(getBiggest(arr));
    }

    private static int getBiggest(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            if (max < i) max = i;
        }
        return max;
    }
}
