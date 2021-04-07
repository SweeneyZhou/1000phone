package com.qianfeng.day0407.homework;

import java.util.Date;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

/*
* 1.重写equals方法，比较两个对象的所有属性是否相同
2.重写toString方法

3.使用字符串的方法完成
a.将手机号的后四位变成"xxxx"
b.将用户输入的话中的，"你"和"你呀"变成"x"
c.生成四位验证码，并判断输入是否成功
d.找出字符串中所有连续的"abc"
* */
public class Test1 {
    String name;
    String gender;
    int level;
    Date birthday;

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String phoneNum="13231242314";
        System.out.println(phoneNum.substring(0,phoneNum.length()-4)+"xxxx");

        String words=scanner.nextLine();
        System.out.println(words.replace("你呀","x").replace("你","x"));

        String valid=getValid();
        System.out.println("请输入验证码:"+valid);
        String inputValid=scanner.next();
        System.out.println(inputValid.compareToIgnoreCase(valid));

        String abc="abcsafalslabcsdfaslabckjlasabcfdssab";
        for (int i=0,len=abc.length();i<len;i++){
            i=abc.indexOf("abc",i);
            if(i==-1)break;
            System.out.println(i);
        }

    }
    private static String getValid() {
        Random random = new Random();
        String res = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int res_len = res.length();
        StringBuilder valid = new StringBuilder();
        for (int j = 0; j < 4; j++) {
            valid.append(res.charAt(random.nextInt(res_len)));
        }
        return valid.toString();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test1 test1 = (Test1) o;
        return level == test1.level && Objects.equals(name, test1.name) && Objects.equals(gender, test1.gender) && Objects.equals(birthday, test1.birthday);
    }

    @Override
    public String toString() {
        return "{" +
                "姓名:" + name +
                ", 性别:" + gender +
                ", 等级:" + level +
                ", 生日:" + birthday +
                '}';
    }
}
