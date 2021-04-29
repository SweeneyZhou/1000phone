package com.qianfeng.day0414.homework;

import java.io.*;
import java.util.Objects;

public class Test1 {
    public static void main(String[] args) {

        String source="C:\\Users\\sweeney\\Desktop\\a";
        String target="C:\\Users\\sweeney\\Desktop\\b";
        File fileSource=new File(source);
        File fileTarget=new File(target);
        new Thread(new CopyFileRunnable(fileSource,fileTarget)).start();
    }
}
class CopyFileRunnable implements Runnable{
    File source;
    File target;
    CopyFileRunnable(File source,File target){
        this.source=source;
        this.target=target;
    }
    @Override
    public void run() {
        try {
            copy(source,target);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void copy(File source,File target) throws IOException {
        if(!source.isDirectory()){
            if (target.isDirectory()){
                if (!target.exists()){
                    if (!target.mkdir())return;
                }
                target=new File(target+"\\"+source.getName());
            }
            copyFile2File(source,target);
        }else {
            if (!target.exists())
                if (!target.mkdir())return;
            if (target.isDirectory()){
                for (File file : Objects.requireNonNull(source.listFiles())) {
                    new Thread(new CopyFileRunnable(file,new File(target+"\\"+file.getName()))).start();
                }
            }
        }
    }

    private static void copyFile2File(File source, File target) throws IOException {
        if (source.isDirectory()||target.isDirectory())return;
        FileInputStream fis=new FileInputStream(source);
        BufferedInputStream bis=new BufferedInputStream(fis);
        FileOutputStream fos=new FileOutputStream(target);
        BufferedOutputStream bos=new BufferedOutputStream(fos);
        byte[] b=new byte[1024];
        for (int n;(n=bis.read(b))!=-1;){
            bos.write(b,0,n);
            bos.flush();
        }
        bos.close();
        bis.close();
    }
}
