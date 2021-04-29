package com.qianfeng.day0407.homework;
/*
* d.找出字符串中所有连续的"abc"
* */
public class Test3d {
    public static void main(String[] args) {
        String abc="abcsafalslabcsdfaslabckjlasabcfdssab";
        System.out.println("字符串:"+abc);
        System.out.println("其中abc出现的位置:");
        for (int i=0,len=abc.length();i<len;i++){
            i=abc.indexOf("abc",i);
            if(i==-1)break;
            System.out.println(i);
        }
    }
}
