package com.qianfeng.day0330.homework;

public class Square {
    double a;

    public Square(double a) {
        this.a = a;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getArea(){
        return a*a;
    }
    public double getCircumference(){
        return 4*a;
    }
}
