package com.qianfeng.day0330;
/*
一.
1. 定义类 Test1,类中定义 main方法,定义int类型a为10, b为10.
2. 定义printNum方法,参数为(int iVar, int iVar2),返回值无,输出iVar和iVar2的值
3. 定义doubling方法,参数为(int r, int p),返回值无,方法内r翻倍,p翻倍,并调用printNum方法,输出r和p的值
4. 定义doubling方法,参数为(int r),返回值int, 方法内r翻倍,返回r.
5. main方法中,调用printNum方法,传入a,b
6. main方法中,调用doubling方法,传入a,b
7. main方法中,调用printNum方法,传入a,b
8. main方法中,调用doubling方法,传入a,用a接收返回值
9. main方法中,调用doubling方法,传入b,用b接收返回值
10. main方法中,调用printNum方法,传入a,b
*
二.
1.定义getValue方法，获取三个数中的最值，能够通过字符串，指定获取最大值或者最小值。
2.getValue中，带有String类型参数，可以指定“大”或者“小”
3.分别定义最大值方法，最小值方法，以供getValue调用。
*
三.
1.定义round方法，接收一位小数，实现四舍五入运算，并返回结果。
* */
public class Test1 {
    public static void main(String[] args) {
        int a=10,b=10;
        printNum(a,b);
        doubling(a,b);
        printNum(a,b);
        a=doubling(a);
        b=doubling(b);
        printNum(a,b);

        System.out.println(getValue("大",2,3,4));

        System.out.println(round(3.14));
    }
    public static void printNum(int iVar,int iVar2){
        System.out.println(iVar);
        System.out.println(iVar2);
    }
    public static void doubling(int r,int p){
        r*=2;
        p*=2;
        printNum(r,p);
    }
    public static int doubling(int r){
        r*=2;
        return r;
    }
    public static int getValue(String s,int a,int b,int c){
        switch (s){
            case "大":
                return getMax(a,b,c);
            case "小":

                return getMin(a,b,c);
            default:
                return 0;
        }

    }

    public static int getMin(int a, int b, int c) {
        return Math.max(a,Math.max(b,c));
    }

    public static int getMax(int a, int b, int c) {
        return Math.min(a,Math.min(b,c));
    }
    public static long round(double i){
        return Math.round(i);
    }
}
