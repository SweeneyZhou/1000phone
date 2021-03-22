package com.qianfeng.day0320;

import java.util.Random;

/*
 * 1、
 * 随机生成6组4位字符组成的验证码。
 * 验证码由大小写字母、数字字符组成。
 * */
public class Test1_1 {

    static final int TOTAL = 6;//验证码的个数
    static final int LENGTH = 4;//验证码的长度

    public static void main(String[] args) {
        Random random=new Random();
        String res="1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int res_len=res.length();
        for (int i=0;i<TOTAL;i++){
            StringBuilder valid=new StringBuilder();
            for(int j=0;j<LENGTH;j++){
                valid.append(res.charAt(random.nextInt(res_len-1)));
            }
            System.out.println(valid);
        }
    }
}
