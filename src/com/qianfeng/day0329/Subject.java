package com.qianfeng.day0329;

public class Subject {
    private String name;
    private int period;
    private int point;

    public Subject(String name, int period, int point) {
        this.name = name;
        this.period = period;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "{ " +
                "学科名:" + name + ", " +
                "学时:" + period + ", " +
                "积分:" + point +
                " }";
    }
}
