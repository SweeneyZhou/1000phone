package com.qianfeng.day0322.homework;
/*
* 1、输出 int数组中能被3整除的元素
* */
public class Test1 {
    public static void main(String[] args) {
        int[] arr1={1,2,123,123123,23321,6644};
        for (int i : arr1) {
            if (i%3==0) System.out.println(i);
        }
    }
}
