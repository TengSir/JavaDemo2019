package com.oracle.java.advance.t9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileOutputStreamDemo {
    public static void main(String[] args) {
        /**
         * 字节输出流一次性可以写一个字节到指定到文件中
         * 输出流默认是覆盖文件里面的内容呢，
         * 要想追加内容，必须在创建输出流对象的构造器后面传入一个true参数
         */
        try {
            FileOutputStream  out=new FileOutputStream(new File("resource/test.txt"),true);
//            out.write(97);
//            out.write(98);
//            out.write(99);
//            out.write(100);
//            out.write(101);
            out.write("我有一个梦想,挣它一个亿".getBytes());
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
