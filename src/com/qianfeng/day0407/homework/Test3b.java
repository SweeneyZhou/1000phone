package com.qianfeng.day0407.homework;
/*
* b.将用户输入的话中的，"你"和"你呀"变成"x"
* */
import java.util.Scanner;

public class Test3b {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String words=scanner.nextLine();
        System.out.println(words.replace("你呀","x").replace("你","x"));
    }
}
