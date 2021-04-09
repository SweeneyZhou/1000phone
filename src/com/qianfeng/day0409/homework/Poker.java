package com.qianfeng.day0409.homework;

public class Poker implements Comparable<Poker> {
    Color color;
    Point point;

    public Poker(Color color,Point point) {
        this.color = color;
        this.point = point;
    }
    @Override
    public String toString() {
        if(color!=null)
            return color.toString()+point.toString();
        else return point.toString();
    }

    @Override
    public int compareTo(Poker o) {
        int a,b;
        if(color==null)a=1000;
        else a=color.ordinal()*100;
        if(o.color==null)b=1000;
        else b=o.color.ordinal()*100;
            return a-b+point.compareTo(o.point);
    }

}

