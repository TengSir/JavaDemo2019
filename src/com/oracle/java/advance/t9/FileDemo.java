package com.oracle.java.advance.t9;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) {
        File  file=new File("/Users/tengsir/Documents/1.eddx");
        File dir=new File("/Users/tengsir");

        File  file1=new File("/Users/tengsir","/Documents/1.eddx");
        System.out.println(file1.isFile());
        System.out.println(file1.isDirectory());
        File  dir1=new File("/Users/tengsir","/work");
        System.out.println(dir1.isDirectory());

        File  file2=new File(dir,"/Documents/2.eddx");

        File  newDir=new File("/Users/tengsir/aaaaaaaaa");
        File  newFile=new File("/Users/tengsir/qqqqqq/cccccc");
        //newDir.mkdir();//
        newFile.mkdirs();


//        try {
//            newFile.createNewFile();
//            newDir.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
