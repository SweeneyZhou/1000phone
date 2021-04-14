package com.qianfeng.day0414.homework;
/*
* 2.有数组[o,x,x,x,x]，自动运行
一秒后数组变成[x,o,x,x,x]
再一秒后数组变成[x,x,o,x,x]
...
直到最后数组变成[x,x,x,x,o]，
当遇到边界时，返回变成[x,x,x,o,x]。
程序能不停运行
* */
public class Test2 {
    static char[] s={'o','x','x','x','x'};
    static int pos=0;
    static int d=1;
    public static void main(String[] args) {
        new Thread(()->{
            while (true){
                System.out.println(s);
                int swap=pos+d;
                char temp=s[swap];
                s[swap]=s[pos];
                s[pos]=temp;
                pos+=d;
                if (pos==0||pos==s.length-1)d=-d;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
