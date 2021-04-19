package com.qianfeng.day0416.homework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;

/*
 * 4.使用Function，根据学生集合获取，平均分
 * */
public class Test4 {
    public static void main(String[] args) {
        Collection<Float> students = new ArrayList<>();
        students.add(95f);
        students.add(78f);
        students.add(56f);
        students.add(67f);
        Function<Collection<Float>, Float> function = (ss -> {
            float s = 0;
            for (Float f : ss) {
                s += f;
            }
            return s / ss.size();
        });
        System.out.println(function.apply(students));
    }
}
