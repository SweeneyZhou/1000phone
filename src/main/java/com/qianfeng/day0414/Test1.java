package com.qianfeng.day0414;

import java.util.Random;

public class Test1 {
    public static void main(String[] args) {
        new Thread(new Account("妻子1")).start();
        new Thread(new Account("丈夫1")).start();
        new Thread(new Account("丈夫2")).start();
        new Thread(new Account("丈夫3")).start();
        new Thread(new Account("丈夫4")).start();
    }
}
class Account implements Runnable{
    private static int value=0;
    String name;

    public Account(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {

            synchronized (Random.class){
                try {
                Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (value<5000) {
                    value+=100;
                    System.out.println(name+"存了100元。账户余额:"+value);
                }else return;
            }
    }
}
}
