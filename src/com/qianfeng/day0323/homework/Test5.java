package com.qianfeng.day0323.homework;
/*
* 5.游戏
              {1,2,3,4,5,0,7,8,9}，输入d
              {1,2,3,4,5,7,0,8,9}，输入d
              {1,2,3,4,5,7,8,0,9}，输入a
              {1,2,3,4,5,7,0,8,9}
* */

import java.util.Arrays;
import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(a));
        System.out.println("请键入方向（a或d,键入q退出）：");
        Scanner scanner = new Scanner(System.in);
        for (String s = ""; !"q".equals(s); ) {
            s = scanner.next();
            switch (s) {
                case "d":
                    for (int i = 0; i < a.length; i++) {
                        if (i != a.length - 1 && a[i] == 0) {
                            a[i] = a[i + 1];
                            a[i + 1] = 0;
                            break;
                        }
                    }
                    break;
                case "a":
                    for (int i = 0; i < a.length; i++) {
                        if (i != 0 && a[i] == 0) {
                            a[i] = a[i - 1];
                            a[i - 1] = 0;
                            break;
                        }
                    }
                    break;
                default:
                    break;
            }
            System.out.println(Arrays.toString(a));
        }
    }
}
