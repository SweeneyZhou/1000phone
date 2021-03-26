package com.qianfeng.day0326.homework;

import java.util.Random;
import java.util.Scanner;

/*
* 2.用户输入“石头”，“剪刀”，“布”，
*   与方法随机生成的“石头”，“剪刀”，“布”，进行比较，
*   输出用户“赢了”、“输了”，“平局”
* */
public class Test2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s;

        do {
            System.out.println("请输入石头、剪刀或者布:(输入q退出)");

            Finger f1,f2;
            s=scanner.nextLine();
            if ("q".equals(s))return;
            f1=getByName(s);
            if (f1==null){
                System.out.println("您的输入有误,请重新输入！");
                continue;
            }
            f2=random();

            System.out.println("你出的是:"+f1);
            System.out.println("电脑出的是:"+f2);

            switch (fight(f1,f2)){//比大小
                case -2:
                case 1:
                    System.out.println("你赢了！");break;
                case 2:
                case -1:
                    System.out.println("电脑胜！");break;
                default:
                    System.out.println("平局！");
            }
            System.out.println("-------------------------------");
        }while (true);
    }
    public static int fight(Finger f1, Finger f2){
        return f1.ordinal()-f2.ordinal();
    }
    public static Finger getByName(String s){
        for (Finger finger : Finger.values()) {
            if (finger.name.equals(s))return finger;
        }
        return null;
    }
    public static Finger random(){
        Random random=new Random();
        return Finger.values()[random.nextInt(Finger.values().length)];
    }
    enum Finger{
        CLOTH("布"),SCISSORS("剪刀"),STONE("石头");

        private final String name;

        Finger(String s) {
            this.name=s;
        }
        @Override
        public String toString() {
            return name;
        }
    }
}
