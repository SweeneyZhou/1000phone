package com.qianfeng.day0331.homework;

public class Bus extends Transportation {
    private String[] stations;

    public Bus() {
    }

    public void getInStation() {
        System.out.println("公交车靠站");
    }

    public void getOutStation() {
        System.out.println("公交车出站");
    }

    public String[] getStations() {
        return stations;
    }

    public void setStations(String[] stations) {
        this.stations = stations;
    }
}
