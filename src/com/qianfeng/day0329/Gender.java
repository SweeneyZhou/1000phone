package com.qianfeng.day0329;

public enum Gender {
    MALE("男"), FEMALE("女");
    private final String name;

    Gender(String s) {
        name = s;
    }

    @Override
    public String toString() {
        return name;
    }
}
