package com.qianfeng.day0322;
/*
* 输出
* * * *
*   * *
*     *
* */
public class Test3 {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(j>=i) System.out.print("* ");//打印*空格
                else System.out.print("  ");//打印2个空格
            }
            System.out.println();
        }
    }
}
