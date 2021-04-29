package com.qianfeng.day0416.homework;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.Properties;

/*
 * 5.使用反射读取配置文件
 * */
public class Test5 {
    public static void main(String[] args) throws Exception {
        System.out.println("读取配置文件:");
        Properties properties = new Properties();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("src/com/qianfeng/day0416/homework/_config.properties"));
        properties.load(bis);
        properties.list(System.out);

        System.out.println("使用反射获取配置文件实例:");
        Class<?> cls = Class.forName("com.qianfeng.day0416.homework.config");
        Object o = cls.getDeclaredConstructor().newInstance();
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            field.set(o, properties.getProperty(field.getName()));
        }
        System.out.println(o);
    }
}

class config {
    String user;
    String password;
    String database;
    String driver;

    @Override
    public String toString() {
        return "config{\n" +
                "\tuser='" + user + '\'' +
                ", \n\tpassword='" + password + '\'' +
                ", \n\tdatabase='" + database + '\'' +
                ", \n\tDriver='" + driver + '\'' + '\n' +
                '}';
    }
}