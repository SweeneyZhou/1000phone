package com.qianfeng.day0318.homework;
/*
* 打印1~100能被3和4整除的数字
* */
public class Test5 {
    public static void main(String[] args) {
        int i=1;
        while(i<=100){
            if(i%3==0&&i%4==0){
                System.out.println(i);
            }
            i++;
        }
    }
}
