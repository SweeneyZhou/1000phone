package com.qianfeng.day0402.homework;

public class SUV extends Auto{
    public static final int SMALL=4295;
    public static final int MEDIUM=5070;

    public SUV() {
    }

    public SUV(String brand, int length, float price) {
        super(brand, length, price);
    }

    public boolean isMedium(){
        return getLength() > SMALL && getLength() <= MEDIUM;
    }
    public boolean isSmall(){
        return getLength()<SMALL;
    }
    public boolean isLarge(){
        return getLength()>MEDIUM;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
