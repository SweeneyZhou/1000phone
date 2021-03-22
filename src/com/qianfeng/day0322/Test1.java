package com.qianfeng.day0322;

/*
 * 打印九九乘法表
 * */
public class Test1 {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "*" + j + "=" + i * j);
                if (j!=i) System.out.print("\t");
            }
            if (i != 9) System.out.println();
        }
    }
}
