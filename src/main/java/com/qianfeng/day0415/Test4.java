package com.qianfeng.day0415;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Test4 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket=new ServerSocket(9595);
            Socket socket=serverSocket.accept();
            InputStream is=socket.getInputStream();

            byte[] b=new byte[1024];

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
