package com.qianfeng.day0416.homework;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Supplier;

/*
 * 3.使用Supplier，输出格式化后的当前时间
 * */
public class Test3 {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        System.out.println(supplier.get());
    }
}
