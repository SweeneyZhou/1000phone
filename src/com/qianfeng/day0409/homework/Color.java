package com.qianfeng.day0409.homework;

enum Color {
    DIAMOND("方片"), CLUB("梅花"), HEART("红心"), SPADE("黑桃");
    private final String name;

    Color(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
