package day0412.homework;
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
            if (!target.isDirectory()){
                copyFile2File(source,target);
            }else{
                if (!target.exists())
                    if (!target.mkdir())return;
                copyFile2File(source,new File(target+"\\"+source.getName()));
            }
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
        FileInputStream isr=new FileInputStream(source);
        FileOutputStream fos=new FileOutputStream(target);
        byte[] b=new byte[1024];
        for (int n;(n=isr.read(b))!=-1;){
            fos.write(b,0,n);
        }
    }
}
