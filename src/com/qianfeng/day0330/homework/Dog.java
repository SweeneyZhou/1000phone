package com.qianfeng.day0330.homework;

public class Dog extends Animal{
    private String nickname;
    private int age;
    private String color;

    public Dog() {
    }

    public Dog(String nickname, int age, String color) {
        this.setFamily("犬科");
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
        System.out.println("汪汪叫");
    }
}
