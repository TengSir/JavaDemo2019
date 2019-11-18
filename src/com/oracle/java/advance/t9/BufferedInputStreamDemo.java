package com.oracle.java.advance.t9;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class BufferedInputStreamDemo {
    public static void main(String[] args) throws Exception{
        /**
         * 缓存区字节输入流
         * 他可以提前讲一部分数据读取到内存的缓存中，
         * 方便提高后续的读取效率
         */
        File  f=new File("resource/sugar.flv");

        BufferedInputStream in=new BufferedInputStream(new FileInputStream("resource/sugar.flv"),1024*1024*10);

        System.out.println("当前要被读取的文件大小："+f.length());
        System.out.println( "当前缓存区还剩余的字节："+in.available());
        Thread.sleep(4000);
        byte[] bs=new byte[256];
        long lastLength=0;
        int length=-1;
        while((length=in.read(bs))!=-1){
            System.out.println("当前读取了"+length+"个字节的数据");
            System.out.println("目前文件还剩余："+(lastLength=(f.length()-length)));

        }


    }
}
