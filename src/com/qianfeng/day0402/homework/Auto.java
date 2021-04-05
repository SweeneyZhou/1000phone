package com.qianfeng.day0402.homework;

public class Auto {
    private String brand;
    private int length;
    private float price;

    public Auto() {
    }

    public Auto(String brand, int length, float price) {
        this.brand = brand;
        this.length = length;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "[" +
                 brand +
                ", 车身长度" + length +
                ", 价格" + price +
                ']';
    }
}
