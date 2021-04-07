package com.qianfeng.day0407.homework;
/*
* 1.重写equals方法，比较两个对象的所有属性是否相同
2.重写toString方法
* */
import java.util.Objects;

public class Player {
    String name;
    String gender;
    int level;

    public Player() {
    }

    public Player(String name, String gender, int level) {
        this.name = name;
        this.gender = gender;
        this.level = level;
    }

    public static void main(String[] args) {
        Player player1=new Player("zs","男",13);
        Player player2=new Player("zs","男",13);
        Player player3=new Player("zs","男",25);
        System.out.println(player1.equals(player2));
        System.out.println(player1.equals(player3));
        System.out.println(player1);
        System.out.println(player2);
        System.out.println(player3);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return level == player.level && Objects.equals(name, player.name) && Objects.equals(gender, player.gender) ;
    }

    @Override
    public String toString() {
        return "{" +
                "玩家昵称:" + name +
                ", 性别:" + gender +
                ", 等级:" + level +
                '}';
    }
}
