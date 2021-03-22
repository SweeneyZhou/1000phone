package com.qianfeng.day0322.homework;

import java.util.Arrays;

/*
* 3、将两个int数组拼接成一个新的int数组
* */
public class Test3 {
    public static void main(String[] args) {
        int[] a1={123,436,879,34},a2={3242,7645,234,43,523};
        int[] arr=new int[a1.length+a2.length];
        for (int i = 0; i < a1.length; i++) {
            arr[i]=a1[i];
        }
        //System.arraycopy(a1, 0, arr, 0, a1.length);
        for (int i = a1.length; i < arr.length; i++) {
            arr[i]=a2[i-a1.length];
        }
        //System.arraycopy(a2, a1.length - a1.length, arr, a1.length, arr.length - a1.length);
        System.out.println(Arrays.toString(arr));
    }
}
