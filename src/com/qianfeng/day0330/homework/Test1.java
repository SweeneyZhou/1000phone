package com.qianfeng.day0330.homework;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Animal[] animals=new Animal[2];
        for (int i = 0; i < animals.length; i++) {
            animals[i]=new Animal();
            System.out.println("请输入动物的种类:");
            animals[i].setFamily(scanner.next());
            System.out.println("有几对翅膀:");
            animals[i].setWings(scanner.nextInt());
            System.out.println("有几条腿:");
            animals[i].setLeg(scanner.nextInt());
        }
        for (Animal animal : animals) {
            System.out.println(animal);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Cat cat=new Cat();
        cat.setNickname("小咪");
        cat.setAge(1);
        cat.setColor("白色");
        cat.noise();
        Dog dog=new Dog();
        dog.setNickname("大黄");
        dog.setAge(5);
        dog.setColor("黄色");
        dog.noise();

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Circle circle=new Circle(3);
        System.out.println("圆的周长:"+circle.getCircumference());
        System.out.println("圆的面积:"+circle.getArea());
        Square square=new Square(4);
        System.out.println("正方形的周长:"+square.getCircumference());
        System.out.println("正方形的面积:"+square.getArea());
    }
}
