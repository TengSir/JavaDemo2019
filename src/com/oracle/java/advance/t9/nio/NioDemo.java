package com.oracle.java.advance.t9.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class NioDemo {
    public static void main(String[] args) throws Exception {
        /**
         * NIO技术使用了Channel，Buffer，Selector代替了原来的IO类。
         * NIO使用底层的Native函数，绕过了jvm堆内存区的数据操作，直接使用系统
         * 的native函数操作数据，并且使用buffer缓存堆数据做操作大大提高了读写效率
         * 而且，提供了非阻塞的异步IO，基于selector的事件监听机制可以降低传统的多个
         * io操作需要开启多个Thread的业务场景。现在可以使用一个线程通过将多个IO操作注册到
         * 一个selector中，让selector监听所有的IO代码中是否有事件发生，然后去对已经有数据
         * 可以操作的IO进行读写。从而大大提高程序的资源利用率。
         */

        File f=new File("resource/test.txt");
        FileChannel  fileChannel=new FileInputStream(f).getChannel();
        ByteBuffer  bf=ByteBuffer.allocate(1024);//使用byteBuffer在内存中开辟1024个缓存空间，用来暂存从文件通道里读取到的数据

        while(fileChannel.position()<fileChannel.size()){
            int length=fileChannel.read(bf);
            bf.flip();
            System.out.println(new String(bf.array(),0,length));
        }
    }
}
