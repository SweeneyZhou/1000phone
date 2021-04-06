package com.qianfeng.day0406;

import java.util.Calendar;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int year=scanner.nextInt();
        int mon=scanner.nextInt();
        int date=scanner.nextInt();
        Calendar c=Calendar.getInstance();
        c.set(year,mon-1,date);
        long time=Calendar.getInstance().getTimeInMillis()-c.getTimeInMillis();
        System.out.println(time/1000/3600/24);
    }
}