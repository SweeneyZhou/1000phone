package com.qianfeng.day0324.homework;
/*
* 1.输入3个值，返回最大值
* */
import java.util.Arrays;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        int[] a=new int[3];
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入3个数：");
        for (int i = 0; i < a.length; i++) {
            a[i]=scanner.nextInt();
        }
        System.out.println("在"+ Arrays.toString(a) +"中最大的是:");
        System.out.println(getBiggest(a[0],a[1],a[2]));
    }
    public static int getBiggest(int a,int b,int c){
        return Math.max(a,Math.max(b,c));
    }
}
