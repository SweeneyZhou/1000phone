package com.qianfeng.day0324.homework;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * 6.参数是int的二维数组，返回0元素所在位置
 * */
public class Test6 {
    public static void main(String[] args) {
        int num = 0;
        int[][] arr = {
                {2, 3, 45, 6, 56, 6},
                {0, 41, 12, 34, 9, 9, 0, 6},
                {21, 4, 56, 36, 0}
        };
        System.out.println("int类型的二维数组:");
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println(num + "所在位置下标为:");
        ArrayList<int[]> pos = getPosition(arr, num);
        for (int[] p : pos) {
            System.out.println(Arrays.toString(p));
        }
        System.out.println("个数为:" + pos.size());
    }

    private static ArrayList<int[]> getPosition(int[][] arr, int num) {
        ArrayList<int[]> arrayList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == num) arrayList.add(new int[]{i, j});
            }
        }
        return arrayList;
    }
}
