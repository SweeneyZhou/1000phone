package com.qianfeng.day0330.homework;

public class Cat extends Animal{
    private String nickname;
    private int age;
    private String color;

    public Cat() {
    }

    public Cat(String nickname, int age, String color) {
        this.setFamily("猫科");
        this.setWings(0);
        this.setLeg(4);
        this.nickname = nickname;
        this.age = age;
        this.color = color;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public void noise(){
        System.out.println("喵喵叫");
    }
}
