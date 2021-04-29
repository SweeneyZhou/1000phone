package com.qianfeng.day0408.homework;

import java.util.ArrayList;
import java.util.Random;

/*
* 4.定义Integer的ArrayList集合
a.计算总和
b.求出最大值
c.将集合内容倒置
* */
public class Test4 {
    private static final int N=10;
    public static void main(String[] args) {
        Random random=new Random();
        ArrayList<Integer> integerArrayList= new ArrayList<>();
        for (int i = 0; i < N; i++) {
            integerArrayList.add(random.nextInt(1000) + 1);
        }
        System.out.println(integerArrayList);
        int sum=0;
        for (Integer integer : integerArrayList) {
            sum+=integer;
        }
        System.out.println("总和为:"+sum);
        int max=integerArrayList.get(0);
        for (Integer integer : integerArrayList) {
            if(max<integer)max=integer;
        }
        System.out.println("最大值:"+max);

        for (int i = 0,size=integerArrayList.size(),count=size/2; i <count; i++) {
            //交换两个位置的值
            int temp=integerArrayList.get(i);
            integerArrayList.set(i,integerArrayList.get(size-i-1));
            integerArrayList.set(size-i-1,temp);
        }
        System.out.println("倒序:");
        System.out.println(integerArrayList);
    }
}
