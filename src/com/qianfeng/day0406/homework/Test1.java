package com.qianfeng.day0406.homework;

import java.util.Calendar;

public class Test1 {

    public static void main(String[] args) {

        Calendar c= Calendar.getInstance();
        Calendar mayDay=Calendar.getInstance();
        mayDay.set(mayDay.get(Calendar.YEAR),Calendar.MAY,1);
        if(c.after(mayDay))mayDay.set(Calendar.YEAR,mayDay.get(Calendar.YEAR)+1);
        System.out.println((mayDay.getTimeInMillis()-c.getTimeInMillis())/1000/3600/24);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        String IP="192.168.0.1";
        String[] str=IP.split("\\.");
        for (String s : str) {
            System.out.println(s);
        }
    }
}
