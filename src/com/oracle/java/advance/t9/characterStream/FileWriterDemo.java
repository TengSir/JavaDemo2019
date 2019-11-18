package com.oracle.java.advance.t9.characterStream;

import java.io.FileWriter;

public class FileWriterDemo {
    public static void main(String[] args)  throws Exception{
        FileWriter writer=new FileWriter("resource/test.txt",true);
        writer.write("我有一个梦想xxxx");
        writer.close();
    }
}
