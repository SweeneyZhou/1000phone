package com.qianfeng.day0319.homework;
/*
* 计算1~100内的偶数之和
* */
public class Test1 {
    public static void main(String[] args) {
        int sum=0;
        for (int i=1;i<=100;i++){
            if(i%2==0)sum+=i;
        }
        System.out.println(sum);
    }
}
