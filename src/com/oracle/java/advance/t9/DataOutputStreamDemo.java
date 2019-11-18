package com.oracle.java.advance.t9;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataOutputStreamDemo {
    public static void main(String[] args)  throws Exception{
        DataOutputStream out=new DataOutputStream(new FileOutputStream("resource/ttt.txt"));
        out.writeInt(2322);
        out.writeBoolean(false);
        out.writeShort(2);
        out.writeFloat(23.22f);
        out.writeUTF("tttt");

    }
}
