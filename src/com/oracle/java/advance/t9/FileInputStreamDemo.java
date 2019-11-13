package com.oracle.java.advance.t9;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class FileInputStreamDemo {
    public static void main(String[] args) {
        /**
         * 字节流可以一次读取一个字节的方式把文件的数据全部读取出来
         */
//        try {
//            FileInputStream  in=new FileInputStream("resource/music.wav");
//            //字节输入流读取一个文件的标准代码
//            int b=-1;
//            while((b=in.read())!=-1){
//                System.out.println(b);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        /**
         *
         * 字节流也可以一次性读取一个数组的数据，提高读取效率
         */

        try {
            FileInputStream  in=new FileInputStream("resource/music.wav");
            //字节输入流读取一个文件的标准代码
            byte[] bs=new byte[1024*1024*1024];
            int length=-1;
            while((length=in.read(bs))!=-1){
                System.out.println(length);
                //System.out.println(Arrays.toString(bs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
