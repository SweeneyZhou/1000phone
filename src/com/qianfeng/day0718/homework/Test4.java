package com.qianfeng.day0718.homework;
/*
* 打印1~100包含3的数字
* */
public class Test4 {
    public static void main(String[] args) {
        int i=1;
        while(i<=100){
            if(String.valueOf(i).contains("3")){
                System.out.println(i);
            }
            i++;
        }
    }
}
