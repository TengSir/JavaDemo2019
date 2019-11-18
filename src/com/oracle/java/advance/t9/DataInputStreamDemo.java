package com.oracle.java.advance.t9;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class DataInputStreamDemo {
    public static void main(String[] args) throws  Exception{
        /**
         * dataXXXStream是高级流，针对特定数据提供了读写方法
         * 可以对8中基本类型和string专门做读写
         */
        DataInputStream  in=new DataInputStream(new FileInputStream("resource/test.txt"));

        in.readInt();
        in.readFloat();
    }
}
