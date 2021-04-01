package com.qianfeng.day0401.homework;

public class Keyboard implements Usb {
    @Override
    public void connect() {
        System.out.println("键盘已连接");
    }
}
