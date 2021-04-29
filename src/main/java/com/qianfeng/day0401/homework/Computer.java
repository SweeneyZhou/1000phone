package com.qianfeng.day0401.homework;

public class Computer {

    private Usb[] usb;

    public void startUp() {
        System.out.println("电脑已开机");
        for (Usb u : usb) {
            u.connect();
        }
    }

    public Computer() {
    }

    public Computer(Usb[] usb) {
        this.usb = usb;
    }

    public Usb[] getUsb() {
        return usb;
    }

    public void setUsb(Usb[] usb) {
        this.usb = usb;
    }
}
