package com.qianfeng.day0330.homework;

public class Animal {
    private String family;
    private int leg;
    private int wings;

    public Animal() {
    }

    public Animal(String family, int leg, int wings) {
        this.family = family;
        this.leg = leg;
        this.wings = wings;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public int getLeg() {
        return leg;
    }

    public void setLeg(int leg) {
        this.leg = leg;
    }

    public int getWings() {
        return wings;
    }

    public void setWings(int wings) {
        this.wings = wings;
    }

    @Override
    public String toString() {
        return family+"有"+wings+"对翅膀和"+leg+"条腿";
    }
}
