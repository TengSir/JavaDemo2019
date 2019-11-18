package com.oracle.java.advance.t9.characterStream;

import java.io.FileReader;
import java.util.Arrays;

public class FileReaderDemo {
    public static void main(String[] args)  throws Exception{
        FileReader reader=new FileReader("resource/test.txt");
        char[] cs=new char[1024];
        int code=-1;
        while((code=reader.read(cs))!=-1){
            System.out.println(new String(cs));
        }
    }
}
