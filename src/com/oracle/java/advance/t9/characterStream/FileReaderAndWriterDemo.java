package com.oracle.java.advance.t9.characterStream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileReaderAndWriterDemo {
    public static void main(String[] args) throws Exception {
        /**
         * 字符文件输入和文件输出流读写一个文件
         */
        FileReader  reader=new FileReader("resource/test.txt");
        FileWriter  writer=new FileWriter("resource/test1.txt");
        char[] bs=new char[100];
        int length=-1;
        while((length=reader.read(bs))!=-1){
            writer.write(bs,0,length);
            writer.flush();
        }
        writer.close();
        reader.close();

    }
}
