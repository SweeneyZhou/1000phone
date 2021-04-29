package com.qianfeng.day0410.homework;

import java.util.HashMap;
import java.util.Map;

/*
* 一
现在有一个map集合如下：
        Map<Integer,String> map= new HashMap<>();
        map.put(1,"张三丰");
        map.put(2,"周芷若");
        map.put(3,"汪峰");
        map.put(4,"灭绝师太");
要求：
1.遍历集合，并将序号与对应人名打印。
2.向该map集合中插入一个编码为5姓名为李晓红的信息
3.移除该map中的编号为1的信息
4.将map集合中编号为2的姓名信息修改为"周林"

* */
public class Test1 {
    public static void main(String[] args) {
        Map<Integer,String> map= new HashMap<>();
        map.put(1,"张三丰");
        map.put(2,"周芷若");
        map.put(3,"汪峰");
        map.put(4,"灭绝师太");
//        1.遍历集合，并将序号与对应人名打印。
        printMap(map);
        System.out.println("1~~~~~~~~~~~~~");
//        2.向该map集合中插入一个编码为5姓名为李晓红的信息
        map.put(5,"李晓红");
        printMap(map);
        System.out.println("2~~~~~~~~~~~~~");
//        3.移除该map中的编号为1的信息
        map.remove(1);
        printMap(map);
        System.out.println("3~~~~~~~~~~~~~");

//        4.将map集合中编号为2的姓名信息修改为"周林"
        map.put(2,"周林");
        printMap(map);
        System.out.println("4~~~~~~~~~~~~~");

    }
    public static <K,V> void printMap(Map<K,V> map){
        for (K k : map.keySet()) {
            System.out.println(k+"---"+map.get(k));
        }
    }
}
