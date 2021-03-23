package com.qianfeng.day0323.homework;

import java.util.Arrays;
import java.util.Random;

/*
* 3.将一个int数组打乱{1,2,3,4,5,6,7,8,0}(2种方法)
* 方法一：遍历每一个位置，每次生成一个新的位置，交换这两个位置上的值
* */
public class Test3 {
    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6,7,8,9,0,32,76};
        Random r=new Random();
        //遍历每一个位置，每次生成一个新的位置，交换这两个位置上的值
        for (int i = 0; i < a.length; i++) {
            int t=r.nextInt(a.length);
            a[i]+=a[t];
            a[t]=a[i]-a[t];
            a[i]-=a[t];
        }
        System.out.println(Arrays.toString(a));
    }
}
