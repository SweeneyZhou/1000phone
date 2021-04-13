package com.qianfeng.day0412.homework;
/*
*
* */
import java.io.*;
import java.util.Objects;

public class Test1 {
    public static void main(String[] args) throws IOException {
        String source="C:\\Users\\sweeney\\Desktop\\a";
        String target="C:\\Users\\sweeney\\Desktop\\b";
        File fileSource=new File(source);
        File fileTarget=new File(target);
        if(fileSource.exists())copy(fileSource,fileTarget);
    }
    private static void copy(File source,File target) throws IOException {
        if(!source.isDirectory()){
            if (target.isDirectory()){
                if (!target.exists()){
                    if (!target.mkdir())return;
                }
                target=new File(target+"\\"+source.getName());
//                copyFile2File(source,new File(target+"\\"+source.getName()));
            }
            copyFile2File(source,target);
        }else {
            if (!target.exists())
                if (!target.mkdir())return;
            if (target.isDirectory()){
                for (File file : Objects.requireNonNull(source.listFiles())) {
                    copy(file,new File(target+"\\"+file.getName()));
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
