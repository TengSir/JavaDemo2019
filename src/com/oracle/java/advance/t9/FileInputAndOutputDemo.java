package com.oracle.java.advance.t9;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileInputAndOutputDemo {
    public static void main(String[] args) {
        /**
         * 可以使用FileinputStream和FileOutputStream对一个文件进行复制操作
         */

        try {
            FileInputStream source=new FileInputStream("resource/music.wav");
            FileOutputStream dest=new FileOutputStream("/Users/tengsir/1.wav");
            byte[] bs=new byte[1024*1024*100];
            int length=-1;
            while((length=source.read(bs))!=-1){
                dest.write(bs,0,length);
                System.out.println(length);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {

        }
    }
}
