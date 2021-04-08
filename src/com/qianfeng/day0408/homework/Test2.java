package com.qianfeng.day0408.homework;
/*
* 2.将手机号的中间4位替换成"****"
* */
public class Test2 {
    public static void main(String[] args) {
        String phoneNum="18816548658";
        StringBuilder stringBuilder=new StringBuilder(phoneNum);
        stringBuilder.replace(3,7,"****");
        System.out.println(stringBuilder);
    }
}
