package com.oracle.java.advance.t9;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectInputStreamDemo {
    public static void main(String[] args)  throws Exception{
        /**
         * ObjectInputStream 反序列化就是将之前保存到文件中的对象从文件中再次读取到内存中
         */

        ObjectInputStream  in=new ObjectInputStream(new FileInputStream("resource/hhh.ser"));
        Teacher t=(Teacher) in.readObject();
        t.setAge(55);
        t.setName("jacks");
        System.out.println(t);
    }
}
