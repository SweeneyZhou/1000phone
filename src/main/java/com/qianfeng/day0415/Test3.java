package com.qianfeng.day0415;

import java.io.*;
import java.net.Socket;

public class Test3 {
    static Socket socket;
    public static void main(String[] args) {
        try {
            socket=new Socket("10.11.57.153",8889);
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            try {
//                File file=new File("C:\\Users\\sweeney\\Desktop\\202003251617559376.gif");
//                File file=new File("C:\\Users\\sweeney\\Desktop\\63963471_p0.jpg");
//                File file=new File("C:\\Users\\sweeney\\Desktop\\66093438_p0.jpg");
//                File file=new File("C:\\Users\\sweeney\\Desktop\\65969762_p0.jpg");
//                File file=new File("C:\\Users\\sweeney\\Desktop\\77122228_p0.jpg");
//                File file=new File("C:\\Users\\sweeney\\Desktop\\73136818_p0_master1200.jpg");
//                File file=new File("C:\\Users\\sweeney\\Desktop\\81451534_p0_master1200.jpg");
                File file=new File("C:\\Users\\sweeney\\Desktop\\89069049_p4_master1200.jpg");
//                File file=new File("C:\\Users\\sweeney\\Desktop\\89069049_p1_master1200.jpg");
                FileInputStream fis=new FileInputStream(file);
                BufferedInputStream bis=new BufferedInputStream(fis);

                OutputStream outputStream = socket.getOutputStream();
                byte[] b=new byte[1024];
                while (true){
                    int len = bis.read(b);
                    if (len==-1)break;
                    outputStream.write(b,0,len);
                }
                socket.shutdownOutput();
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                System.exit(0);
            }
        }).start();
    }
}
