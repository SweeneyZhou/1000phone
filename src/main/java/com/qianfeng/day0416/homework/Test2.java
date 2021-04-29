package com.qianfeng.day0416.homework;

import java.io.File;
import java.util.function.Consumer;

/*
 * 2.使用Consumer，计算删除指定文件
 * */
public class Test2 {
    public static void main(String[] args) {
        File f = new File("");
        Consumer<File> x = File::delete;
        if (f.exists()) x.accept(f);
    }
}
