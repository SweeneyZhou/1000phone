package com.qianfeng.day0323.homework;

import java.util.Arrays;
import java.util.Scanner;

/*
* 6.数字0在二维数组中移动
            1	2   3
            4	5   6
            7	8   0
            输入s
            1	2   3
            4	5   0
            7	8   6
            输入d
            1	2   3
            4	0   5
            7	8   6
* */
public class Test6 {
    public static void main(String[] args) {
        int[][] a={
                {1,2,3},
                {4,0,6},
                {7,8,9},
        };
        Scanner scanner=new Scanner(System.in);
        printArrays(a);
        for (String s="";!"q".equals(s);){
            System.out.println("请键入wasd控制移动方向，键入q退出程序:");
            s=scanner.next();
            switch (s){
                case "w":
                    for (int i = 0; i < a.length; i++) {
                        for (int j = 0; j < a[i].length; j++) {
                            if (i!=a.length-1&&a[i][j]==0){
                                a[i][j]=a[i+1][j];
                                a[i+1][j]=0;
                                i=a.length;//退出外层循环标记
                                break;
                            }
                        }
                    }
                    printArrays(a);
                    break;
                case "a":
                    for (int i = 0; i < a.length; i++) {
                        for (int j = 0; j < a[i].length; j++) {
                            if(j!=a[i].length-1&&a[i][j]==0){
                                a[i][j]=a[i][j+1];
                                a[i][j+1]=0;
                                i=a.length;//退出外层循环标记
                                break;
                            }
                        }
                    }
                    printArrays(a);
                    break;
                case "s":
                    for (int i = 0; i < a.length; i++) {
                        for (int j = 0; j < a[i].length; j++) {
                            if(i!=0&&a[i][j]==0){
                                a[i][j]=a[i-1][j];
                                a[i-1][j]=0;
                                i=a.length;//退出外层循环标记
                                break;
                            }
                        }
                    }
                    printArrays(a);
                    break;
                case "d":
                    for (int i = 0; i < a.length; i++) {
                        for (int j = 0; j < a[i].length; j++) {
                            if(j!=0&&a[i][j]==0){
                                a[i][j]=a[i][j-1];
                                a[i][j-1]=0;
                                i=a.length;//退出外层循环标记
                                break;
                            }
                        }
                    }
                    printArrays(a);
                    break;
                case "q":
                    System.out.println("退出程序！");
                    break;
                default:
                    printArrays(a);
                    System.out.println("输入有误！请重新输入！");
            }
        }
    }

    private static void printArrays(int[][] a){
        for (int[] ints : a) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
