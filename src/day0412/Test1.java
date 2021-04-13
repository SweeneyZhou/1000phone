package day0412;

import java.io.File;
import java.util.Objects;

public class Test1 {

    public static void main(String[] args) {
        String dir="C:\\";
        File file=new File(dir);
        if (file.exists())p(file);
        else System.out.println("不存在");

    }
    public static void p(File file){
        if(!file.isDirectory()){
            System.out.println(file.getName());
        }else {
            if (file.listFiles()!=null)
            for (File f : Objects.requireNonNull(file.listFiles())) {
                p(f);
            }
        }
    }
}
