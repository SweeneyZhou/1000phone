package com.qianfeng.day0331.homework;

public class RacingCar extends Transportation {

    private String brand;//品牌
    private String type;//型号
    private float price;//售价

    public RacingCar() {
    }

    public void autopilot() {
        System.out.println("自动驾驶");
    }

    public void automaticParking() {
        System.out.println("自动泊车");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
