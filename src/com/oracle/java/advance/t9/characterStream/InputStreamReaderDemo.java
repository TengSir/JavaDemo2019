package com.oracle.java.advance.t9.characterStream;

import java.io.FileInputStream;
import java.io.InputStreamReader;

public class InputStreamReaderDemo {
    public static void main(String[] args) throws Exception{
        /**
         * 如果提供的是字节流，读取文本文件很不合适，
         *
         * 使用转化流可以将字节流转换成字符流
         */
        FileInputStream in=new FileInputStream("resource/test.txt");

        InputStreamReader  reader=new InputStreamReader(in);

    }
}
