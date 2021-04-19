package com.qianfeng.day0416.homework;

import java.util.function.Predicate;

/*
* 1.使用Predicate，判断指定学生的成绩是否高于平均分
* */
public class Test1 {
    public static void main(String[] args) {
        float[] students={76,86,59,67,95,95,78,95};
        float sum=0;
        for (float s : students) {
            sum+=s;
        }
        float ave=sum/students.length;
        System.out.println("平均分为:"+ave);
        for (int i = 0; i < students.length; i++) {
            if (checked(s->s>ave,students[i]))
            System.out.println("学生"+(i+1)+"大于平均分，分数为"+students[i]+"。");
            else System.out.println("学生"+(i+1)+"不大于平均分，分数为"+students[i]+"。");
        }
    }
    public static boolean checked(Predicate<Float> predicate, float student){
        return predicate.test(student);
    }
}
