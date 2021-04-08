package com.qianfeng.day0408.homework;
/*
* 1.将字符串"abcd1234"变成"1234abcd"
* */
public class Test1 {
    public static void main(String[] args) {
        String str="abcd1234";
        StringBuilder stringBuilder=new StringBuilder(str);
        stringBuilder.append(stringBuilder).delete(0,4).delete(8,stringBuilder.length());
        System.out.println(stringBuilder);
    }
}