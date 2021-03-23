package com.qianfeng.day0323.homework;

import java.util.Arrays;

/*2.将一个二维数组转为一维数组，如：
        将一个
        1	2	3
        4	5	6
        7	8	9
        变成
        1,2,3,4,5,6,7,8,9*/
public class Test2 {
    public static void main(String[] args) {
        int[][] a={
                {1,2,3},
                {4,5,6},
                {7,8,9,0}
        };

        System.out.println("原数组为:{");
        for (int[] ints : a) {
            System.out.println(Arrays.toString(ints)+",");
        }
        System.out.println("};");
        //计算二维数组中元素个数
        int len=0;
        for (int[] ints : a) {
            len+=ints.length;
        }
        //根据元素个数创建一维数组
        int[] b=new int[len];
        //遍历二维数组，保存在新数组中，len从0开始记录新数组的下标
        len=0;
        for (int[] ints : a) {
            for (int i : ints) {
                b[len]=i;
                len++;
            }
        }
        System.out.println("转为一维数组:");
        System.out.println(Arrays.toString(b));
    }
}
