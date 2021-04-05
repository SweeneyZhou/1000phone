package com.qianfeng.day0402.homework;

public class Test1 {
    public static void main(String[] args) {
        SUV[] cars=new SUV[]{
                new SUV("上汽通用五菱",4100,130000),
                new SUV("奔驰",4599,1443244),
                new SUV("领克",5193,234233),
                new SUV("奥迪",4053,231434),
                new SUV("福特",4334,135322),
                new SUV("马自达",4634,165352),
        };
        for (SUV car : cars) {
            if (car.isMedium()) System.out.println(car+"是中型SUV。");
        }

    }
}
