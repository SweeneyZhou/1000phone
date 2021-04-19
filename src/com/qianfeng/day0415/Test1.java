package com.qianfeng.day0415;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        new Thread(()->{
            try {
                DatagramSocket ds=new DatagramSocket();
                while (true){
                    String msg=new Scanner(System.in).next();
                    byte[] b=msg.getBytes(StandardCharsets.UTF_8);
                    DatagramPacket dp=new DatagramPacket(b,0,b.length,InetAddress.getByName("10.11.57.153"),6666);
                    ds.send(dp);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
