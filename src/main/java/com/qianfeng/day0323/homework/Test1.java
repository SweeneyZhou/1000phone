package com.qianfeng.day0323.homework;

import java.util.Arrays;
/*
* 1. 删除int数组中的所有偶数
* */
public class Test1 {

    public static void main(String[] args) {
        int[] num={2,3,57,933,578,684,26,897,3315,7845,9,3,8,5,68};
        System.out.println("原数组为：");
        System.out.println(Arrays.toString(num));
        System.out.println("删除数组中的偶数：");
        int count=0;
        for (int i : num) {
            if (i%2==0)count++;
        }
        int[] num2=new int[num.length-count];
        for (int i = 0,j=0; i < num2.length; i++,j++) {
            if(num[j]%2!=0)num2[i]=num[j];
            else i--;
        }
        System.out.println(Arrays.toString(num2));

    }
}
