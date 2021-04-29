package com.qianfeng.day0318.homework;
/*
* 打印-1+2-3....-99+100的结果
* */
public class Test6 {

    public static void main(String[] args) {
        int i=1;
        boolean flag=false;
        int sum=0;
        while(i<=100){
            if(flag){
                sum+=i;
            }else sum -=i;
            flag=!flag;
            i++;
        }
        System.out.println(sum);
    }
}
