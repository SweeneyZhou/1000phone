package com.qianfeng.day0407.homework;
/*
* 3.使用字符串的方法完成
* a.将手机号的后四位变成"xxxx"
* */
public class Test3a {
    public static void main(String[] args) {
        String phoneNum="13231242314";
        System.out.println(phoneNum.substring(0,phoneNum.length()-4)+"xxxx");
    }
}
