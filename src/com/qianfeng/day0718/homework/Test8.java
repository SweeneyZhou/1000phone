package com.qianfeng.day0718.homework;

/*
 * 2.求水仙花数
 * */
public class Test8 {
    public static void main(String[] args) {
        System.out.println("打印水仙花数");
        int i = 100;
        while (i <= 999) {
            int sum = 0;
            int temp = i;
            sum += (temp % 10) * (temp % 10) * (temp % 10);
            temp /= 10;
            sum += (temp % 10) * (temp % 10) * (temp % 10);
            temp /= 10;
            sum += (temp % 10) * (temp % 10) * (temp % 10);
            if (sum == i) System.out.println(sum);
            i++;
        }

        System.out.println("方法2打印水仙花数");
        int i1 = 100;
        while (i1 <= 999) {
            if (Narcissistic(i1)) System.out.println(i1);
            i1++;
        }

        System.out.println("方法3打印水仙花数");
        int i2 = 100;
        while (i2 <= 999) {
            if (NarUtil(i2) == i2) System.out.println(i2);
            i2++;
        }
    }

    public static int NarUtil(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }

    public static Boolean Narcissistic(int n) {
        int temp = n;
        int sum = 0;
        while (temp != 0) {
            sum += (temp % 10) * (temp % 10) * (temp % 10);
            temp /= 10;
        }
        return sum == n;
    }
}
