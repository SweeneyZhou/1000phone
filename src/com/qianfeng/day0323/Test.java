package com.qianfeng.day0323;

public class Test {
    public static void main(String[] args) {
        int[] arr = {3, 4, 643, 645, 6543, 34};
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        System.out.println(sum);
    }
}
