package com.qianfeng.day0718.homework;

/*
 * 3.求一张0.0001米的纸对折多少次，厚度会超过8848米
 * */
public class Test9 {
    static final double LENGTH = 0.001;
    static final double THK = 8848;

    public static void main(String[] args) {
        double length = LENGTH;
        int count = 0;
        while (length < THK) {
            length *= 2;
            count++;
        }
        System.out.println(count);
    }
}
