package com.qianfeng.day0320;

import java.util.Random;

/*
 * 1、
 * 随机生成6组4位字符组成的验证码。
 * 验证码由大小写字母、数字字符组成。
 * */
public class Test1 {
    static final int TOTAL = 6;//验证码的个数
    static final int LENGTH = 4;//验证码的长度

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < TOTAL; i++) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int j = 0; j < LENGTH; j++) {
                char c = '0';
                int r = random.nextInt(62);
                //System.out.println(r);
                if (r > 35) r += 13;//超过35（大写字母Z的下标），跳过数字9到大写字母A之间的7个数字，和大写字母Z到小写字母A中间的6个符号，加13
                else if (r > 9) r += 7;//0-9位数字，超过9，跳过7个符号，大写字母
                c += r;
                stringBuilder.append(c);
                //System.out.println(c+"----"+r);
            }
            System.out.println(stringBuilder);
        }
    }
}
