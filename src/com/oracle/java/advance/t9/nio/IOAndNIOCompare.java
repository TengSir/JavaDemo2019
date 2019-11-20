package com.oracle.java.advance.t9.nio;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Calendar;

public class IOAndNIOCompare {
    /**
     * 传统IO读写一个文件
     * @throws Exception
     */
    @Test
    public void testIOReadToWrite() throws Exception{
        String  sourcePath="/Users/tengsir/16.上传和下载实现.mp4";
        String  destPath="/Users/tengsir/16.上传和下载实现1.mp4";
        long startTime= Calendar.getInstance().getTimeInMillis();
        File  source=new File(sourcePath);
        File  dest=new File(destPath);
        FileInputStream in=new FileInputStream(source);
        FileOutputStream out=new FileOutputStream(dest);
        byte[] bs=new byte[1024*1024*1024];
        int length=-1;
        while((length=in.read(bs))!=-1){
            out.write(bs,0,length);
        }
        in.close();
        out.close();
        long endTime= Calendar.getInstance().getTimeInMillis();
        System.out.println("IO耗时："+(endTime-startTime)+"毫秒！");
//        File destFile=new File(destPath);
//        destFile.deleteOnExit();
    }
    /**
     * NIO使用流的方式读写一个文件
     * @throws Exception
     */
    @Test
    public void testNIOReadToWrite() throws Exception{
        String  sourcePath="/Users/tengsir/16.上传和下载实现.mp4";
        String  destPath="/Users/tengsir/16.上传和下载实现1.mp4";
        long startTime= Calendar.getInstance().getTimeInMillis();
        FileChannel  source=FileChannel.open(Paths.get(sourcePath), StandardOpenOption.READ);
        FileChannel  dest=FileChannel.open(Paths.get(destPath),StandardOpenOption.CREATE,StandardOpenOption.WRITE);
        ByteBuffer byteBuffer=ByteBuffer.allocate(1024*1024*1024);
        int length=-1;
        while((length=source.read(byteBuffer))!=-1){
            byteBuffer.flip();
            dest.write(byteBuffer);
            byteBuffer.clear();
        }
        source.close();
        dest.close();
        long endTime= Calendar.getInstance().getTimeInMillis();
        System.out.println("NIO耗时："+(endTime-startTime)+"毫秒！");
//        File destFile=new File(destPath);
//        destFile.deleteOnExit();
    }

    /**
     * NIO Channel读写一个文件
     * @throws Exception
     */
    @Test
    public void testNIOChannel() throws Exception{
        String  sourcePath="/Users/tengsir/16.上传和下载实现.mp4";
        String  destPath="/Users/tengsir/16.上传和下载实现1.mp4";
        long startTime= Calendar.getInstance().getTimeInMillis();
        FileChannel  source=FileChannel.open(Paths.get(sourcePath), StandardOpenOption.READ);
        FileChannel  dest=FileChannel.open(Paths.get(destPath),StandardOpenOption.CREATE,StandardOpenOption.WRITE);
        source.transferTo(0,source.size(),dest);
        source.close();
        dest.close();
        long endTime= Calendar.getInstance().getTimeInMillis();
        System.out.println("NIO耗时："+(endTime-startTime)+"毫秒！");
//        File destFile=new File(destPath);
//        destFile.deleteOnExit();
    }
}
