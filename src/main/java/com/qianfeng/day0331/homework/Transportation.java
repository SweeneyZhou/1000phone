package com.qianfeng.day0331.homework;

public class Transportation {
    private int site;
    private float speed;
    private float length;
    private float weight;
    private float height;
    private float width;

    public Transportation() {
    }

    public void speedUp() {
        speed++;
        System.out.println("加速");
    }

    public void speedDown() {
        speed--;
        System.out.println("减速");
    }

    public int getSite() {
        return site;
    }

    public void setSite(int site) {
        this.site = site;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }
}
