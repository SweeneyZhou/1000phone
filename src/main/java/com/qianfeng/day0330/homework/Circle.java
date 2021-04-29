package com.qianfeng.day0330.homework;

public class Circle {
    private double r;
    public Circle(double r){
        this.r=r;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }
    public double getCircumference(){
        return Math.PI*r*2;
    }
    public double getArea(){
        return Math.PI*r*r;
    }
}
