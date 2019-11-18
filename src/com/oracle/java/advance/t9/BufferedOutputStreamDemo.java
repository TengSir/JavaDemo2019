package com.oracle.java.advance.t9;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class BufferedOutputStreamDemo {
    public static void main(String[] args) throws Exception{
        /**
         * BufferedOutputStream这个流，输出数据时是暂时放在内存的缓存区，等待发起flush函数命令，或者close关闭时才将数据彻底写入文件
         */
//              FileOutputStream  out= new FileOutputStream("resource/aaa.txt");
//
//              while(true){
//                  Thread.sleep(1000);
//                  out.write(97);
//                  System.out.println("wirte one data");
//              }
        BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream("resource/aaa.txt"));

        int n=1;
        while(true){
                  Thread.sleep(1000);
                  out.write(97);
                  if(n%5==0&&n!=0){
                      out.flush();
                  }
                  n++;

                  System.out.println("wirte one data");
              }

    }
}
