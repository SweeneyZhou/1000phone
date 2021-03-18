package com.qianfeng.day0718.homework;
/*
* 5.有一个小球，从100米的高空落下，每次落地后弹起的高度是原来的一半，
* 求第十次弹起时的高度以及此时小球经历的总路程
*
* 结果：
* 第i次弹起的高度:0.09765625
* 第i次弹起历经的总路程:299.70703125
* */
public class Test11 {
    static final int COUNT=10;

    public static void main(String[] args) {
        double height=100;
        double sum=0;
        int i=0;
        while(i<10){
            i++;//第i次弹起
            sum+=height*1.5;
            height/=2;//第i次弹起的高度
        }
        System.out.println("第i次弹起的高度:"+height);
        System.out.println("第i次弹起历经的总路程:"+sum);
    }
}
