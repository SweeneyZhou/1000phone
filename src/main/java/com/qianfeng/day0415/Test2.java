package com.qianfeng.day0415;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Test2 {
    static Socket socket=null;
    public static void main(String[] args) {
        try {
            socket=new Socket("10.11.57.153",5555);
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            OutputStream outputStream =null;
            try {
                outputStream = socket.getOutputStream();
                while (true){
                    String s=new Scanner(System.in).next();
                    byte[] b=s.getBytes(StandardCharsets.UTF_8);
                    outputStream.write(b);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            BufferedInputStream bis=null;
            try {
                InputStream inputStream = socket.getInputStream();
                bis=new BufferedInputStream(inputStream);
                while (true){
                    byte[] b=new byte[1024*1024];
                    int len=bis.read(b);
                    System.out.println("来自"+socket.getInetAddress().getHostAddress()+"的消息:"+new String(b,0,len));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    if (bis!=null)bis.close();
                    socket.close();
                    System.exit(0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
