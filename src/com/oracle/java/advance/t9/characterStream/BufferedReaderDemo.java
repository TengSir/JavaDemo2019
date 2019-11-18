package com.oracle.java.advance.t9.characterStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferedReaderDemo {
    public static void main(String[] args) throws Exception{
        BufferedReader reader=new BufferedReader(new FileReader("resource/test.txt"));
        BufferedWriter writer=new BufferedWriter(new FileWriter("resource/test2.txt"));
        String messagge=null;
        while((messagge=reader.readLine())!=null){
            System.out.println(messagge);
            writer.write(messagge);
            writer.newLine();;
            writer.flush();
        }
        writer.close();
        reader.close();

    }
}
