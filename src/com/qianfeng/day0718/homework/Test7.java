package com.qianfeng.day0718.homework;

public class Test7 {
    public static void main(String[] args) {
        double i=1;
        double sum=0;
        boolean flag=false;
        while (i<=100){
            if(i%2==0){
                if(flag){
                    sum+=(i-1)/i;
                    //System.out.printf("+"+(i-1)+"/"+i);
                }else{
                    sum-=(i-1)/i;
                    //System.out.printf("-"+(i-1)+"/"+i);
                }
                flag=!flag;
            }
            i++;
        }
        System.out.println(sum);
    }
}
