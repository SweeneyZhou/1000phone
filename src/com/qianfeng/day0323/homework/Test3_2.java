package com.qianfeng.day0323.homework;

import java.util.Arrays;
import java.util.Random;

/*
 * 3.将一个int数组打乱{1,2,3,4,5,6,7,8,0}(2种方法)
 * 方法二：为数组每一个位置，随机一个新的、互不重复的位置下标
 * */
public class Test3_2 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 15, 51};
        int[] b = new int[a.length];
        Random r = new Random();
        //为数组b赋值，互不相同的位置下标
        for (int i = 0; i < b.length; i++) {
            int t = r.nextInt(a.length);
            b[i] = t;
            for (int j = 0; j < i; j++) {
                if (b[j] == t) {
                    b[i] = 0;
                    i--;
                }
            }
        }
        //b[i]获得a中下标为b[i]的值
        for (int i = 0; i < b.length; i++) {
            b[i] = a[b[i]];
        }
        System.out.println(Arrays.toString(b));
    }
}
