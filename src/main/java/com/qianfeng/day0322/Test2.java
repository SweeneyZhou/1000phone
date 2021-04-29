package com.qianfeng.day0322;

/*
 * 输出
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * */
public class Test2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            System.out.print(i);
            if (i % 3 == 0) {
                System.out.print("\n");
            } else
                System.out.print("\t");
        }
        System.out.println("------------------------");
        for (int i = 0, count = 1; i < 3; i++) {
            for (int j = 0; j < 3; j++, count++) {
                System.out.print(count + "\t");
            }
            System.out.println();
        }
    }
}
