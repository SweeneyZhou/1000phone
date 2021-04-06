package com.qianfeng.day0406.homework;
/*
* 1.计算距离五一劳动节还有几天
2.复习内部类、代码块
3.将一段ip地址，例如：192.168.1.100的每一段获取出来
* */
import java.util.Calendar;

public class Test1 {

    public static void main(String[] args) {

        Calendar c= Calendar.getInstance();
        Calendar mayDay=Calendar.getInstance();
        mayDay.set(mayDay.get(Calendar.YEAR),Calendar.MAY,1);
        if(c.after(mayDay))mayDay.set(Calendar.YEAR,mayDay.get(Calendar.YEAR)+1);
        System.out.println("距离五一劳动节还有:"+(mayDay.getTimeInMillis()-c.getTimeInMillis())/1000/3600/24+"天");

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        String IP="192.168.0.1";
        String[] str=IP.split("\\.");
        for (String s : str)System.out.println(s);
    }
}
