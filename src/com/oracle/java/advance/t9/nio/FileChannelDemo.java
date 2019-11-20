package com.oracle.java.advance.t9.nio;



import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Calendar;
import java.util.Date;

/**
 * FileChannel是一个可读可写的双向文件操作通道
 * 它的获取方式可以从基本的节点流上获取，
 * 也可以使用RandomAccessFile上获取
 * 也可以使用内存直接映射文件的方式打开文件通道
 */
public class FileChannelDemo {

    /**
     * 只读FileChannel演示案例
     * @throws Exception
     */
    @Test
    public void testOnlyReadFileChannel() throws Exception{
        /**
         * 从FileInputStream对象中获取FIleChannel对象,
         *
         * 通过FileInputStream构建的FileChannel是只读对象，
         *
         * 所以只能从文件里读取数据，写入就会抛异常！
         */
        FileChannel  readChannel=new FileInputStream("resource/test.txt").getChannel();
        System.out.println(readChannel.size());//获取当前通过可以读取的这个文件的大小
        System.out.println(readChannel.position());//获取通道当前读取指针指向的位置

        /**
         * 使用输入的FileChannel对象能从文件中读取数据，如下：
         *
         * 但是FileChannel采用Buffer对象来缓存读到的数据，
         * 所以需要准备一个ByteBuffer存储读取到的数据，
         * 然后再从ByteBuffer将读取到的数据提取出来使用。
         */
        ByteBuffer  bf=ByteBuffer.allocate(100);//从内存中分配一个100个字节的缓存区对象
        int length=readChannel.read(bf);//使用FileChannel读取文件中的数据放入到ByteBuffer中，然后该方法返回这一次读取到的字节数量

        System.out.println(new String(bf.array(),0,length));//这里是将ByteBuffer中的数据返回成byte数组，然后构造成String输出在控制台


        /**
         *使用输入的FileChannel对象不能向文件中写入数据，因为它是只读的FileChannel：
         *
         * 如下代码将会抛出 java.nio.channels.NonWritableChannelException（不可写入数据的通道异常）
         */

        ByteBuffer  newBF=ByteBuffer.wrap("Hello World".getBytes());//将字符串转成字节，然后封装到内存中的一个ByteBuffer缓存区
        //readChannel.write(newBF); //这一行抛出这个 java.nio.channels.NonWritableChannelException异常

        readChannel.close();

    }

    /**
     * 只写FileChannel演示案例
     * @throws Exception
     */
    @Test
    public void testOnlyWriteFileChannel() throws Exception{
        /**
         * 从FileOutputStream对象中获取FIleChannel对象,
         *
         * 通过FileOutputStream构建的FileChannel是只写对象，
         *
         * 所以只能往文件里写入数据，读取就会抛异常！
         */
        FileChannel  writeChannel=new FileOutputStream("resource/test.txt",true).getChannel();
        System.out.println(writeChannel.size());//获取当前通过可以读取的这个文件的大小
        System.out.println(writeChannel.position());//获取通道当前读取指针指向的位置


        /**
         *使用输出的FileChannel对象可以向文件中写入数据，因为它是只写的FileChannel：
         *
         * 先将一个特定的字符串转换成功字节数组
         * 然后将字节数组封装成ByteBuffer对象（因为FileChannel只能使用ByteBuffer作为数据操作介质）
         */

        ByteBuffer  newBF=ByteBuffer.wrap("Hello World".getBytes());//将字符串转成字节，然后封装到内存中的一个ByteBuffer缓存区
        writeChannel.write(newBF); //这一行抛出这个 java.nio.channels.NonWritableChannelException异常


        /**
         * 使用输入的FileChannel对象不能从文件中读取数据，如下：
         *
         * 但是FileChannel采用Buffer对象来缓存读到的数据，
         * 所以需要准备一个ByteBuffer存储读取到的数据，
         * 然后再从ByteBuffer将读取到的数据提取出来使用。
         *
         * 只写的FileChannel调用read方法会抛出 java.nio.channels.NonReadableChannelException（不可读取数据的的通道异常）
         */
        ByteBuffer  bf=ByteBuffer.allocate(100);//从内存中分配一个100个字节的缓存区对象，准备将读取到的数据存入到这个缓存区
        int length=writeChannel.read(bf);// 这一行个将抛出 java.nio.channels.NonReadableChannelException（不可读取数据的的通道异常）
       System.out.println(new String(bf.array(),0,length));//这里是将ByteBuffer中的数据返回成byte数组，然后构造成String输出在控制台
        writeChannel.close();
    }

    /**
     * RandomAcessFile  to  FileChannel案例
     * @throws Exception
     */
    @Test
    public void testRandomAcessFileToFileChannel() throws Exception{

        RandomAccessFile  randomAccessFile=new RandomAccessFile("resource/test.txt","rw");
        FileChannel channel=randomAccessFile.getChannel();
        System.out.println(channel.size());
        System.out.println(channel.position());
        channel.position(channel.size());
        System.out.println(channel.position());
        ByteBuffer  byteBuffer=ByteBuffer.allocate(1024);
        byteBuffer.put("没有梦想跟咸鱼一样".getBytes());
        byteBuffer.flip();
        channel.write(byteBuffer);
        System.out.println("已经执行FileChannel的write方法，但是缓存尚未满，而且还未关闭流");
        Thread.sleep(20000);
        channel.close();

    }

    /**
     * 基于内存映射文件的方式直接打开FileChannel对象可以直接使用FileChannel的通道传输文件
     * @throws Exception
     */
    @Test
    public void testFileChannelForFile()throws  Exception{
        FileChannel r=FileChannel.open(Paths.get("resource/test.txt"), StandardOpenOption.READ);


        FileChannel w=FileChannel.open(Paths.get("resource/a.txt"),StandardOpenOption.WRITE,StandardOpenOption.CREATE);

        r.transferTo(0,r.size(),w);//NIO中的通道可以直接将文件对接传输过去
        r.close();
        w.close();

    }


    /**
     * FileChannel可以使用流的方式进行文件读写
     */
    @Test
    public void testFileChannelUseStreamTypeProcessData() throws Exception{
        FileChannel r=FileChannel.open(Paths.get("resource/test.txt"), StandardOpenOption.READ);
        FileChannel w=FileChannel.open(Paths.get("resource/b.txt"),StandardOpenOption.WRITE,StandardOpenOption.CREATE);

        System.out.println(r.size());
        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
        int length=-1;
        while((length=r.read(byteBuffer))!=-1){
            byteBuffer.flip();
            w.write(byteBuffer);
            byteBuffer.clear();
        }
        w.close();
        r.close();
    }

}
