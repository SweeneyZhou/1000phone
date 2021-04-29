package com.qianfeng.day0408.homework;

import java.util.Scanner;

/*
* 3.用一个控制台控制两个用户的依次说话，
先录入两个用户的姓名，例如张三和李四
要求对话内容如下：
张三：xxxx
李四：xxxx
张三：xxx
李四：xxxxx
当一个用户说的话以"~~"结尾时候，终止对话
* */
public class Test3 {
    public static void main(String[] args) {
        String[] name=new String[2];
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入第一位聊天者姓名");
        name[0]=scanner.next();
        System.out.println("请输入第二位聊天者姓名");
        name[1]=scanner.next();
        for (int i = 0;;i++){
            String str=scanner.next();
            System.out.println(name[i%2]+":"+str);
            if (str.endsWith("~~"))break;
        }
    }
}
