package com.qianfeng.day0322.homework;

import java.util.Arrays;

/*
* 2、将一个char数组中的所有小写字母变成大写字母
* */
public class Test2 {
    public static void main(String[] args) {
        char[] c={'a','3','f','A','s','S','7','我','@','!'};
        System.out.println("原数组为:");
        System.out.println(Arrays.toString(c));
        for (int i = 0; i < c.length; i++) {
            if (c[i]>='a'&&c[i]<='z'){
                c[i]+='A'-'a';
            }
        }
        System.out.println("小写字母变成大写字母:");
        System.out.println(Arrays.toString(c));
    }
}
