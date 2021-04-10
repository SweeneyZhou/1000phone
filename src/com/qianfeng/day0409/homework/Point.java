package com.qianfeng.day0409.homework;

enum Point {
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("J"),
    QUEEN("Q"),
    KING("K"),
    ACE("A"),
    TWO("2"),
    BLACK("🐕小王"),
    RED("🐱大王");
    private final String name;

    Point(String s) {
        this.name = s;
    }

    @Override
    public String toString() {
        return name;
    }
}
