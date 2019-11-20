package com.oracle.java.advance.t9.nio;

import org.junit.Test;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Calendar;
/**
 * RandomAcessFile对象是一个专门针对文件的可以随机访问的一个文件对象，支持对文件任意位置的操作。
 *
 * RandomAccessFile  x=new RandomAccessFile("file path", "Mode");
 *
 * RandomAccessFile类型构造器第一个参数传入要指向的文件路径，第二个参数指定该对象对文件的操作模式
 *
 * 第二个是传入的文件操作的模式：
 *
 * r标识只读模式
 *
 * rw标识可读可写模式，但是数据不是立即更新到文件中，先放入缓存，知道缓存满了，或者close等操作才会将数据写入文件
 *
 * rws标识可读可写模式，但是对于文件内容的每次修改都立即将数据和文件的描述信息（主要是修改时间）立即同步写入文件的描述信息区域
 *
 * rwd标识可读可写模式,但是对于文件内容的修改会立即写入文件，而描述信息则不是理解写入文件，是等到流关闭时才将描述信息写入文件
 *
 */
public class RandomAcessFileDemo {
    /**
     * 测试RandomAcessFile的R模式
     * 该模式意思是ReadOnly，此时构建的对象只能对文件尽心读取操作，任何写入操作都会抛出异常
     * @throws Exception
     */
    @Test
    public void testRandomAcessFileRMode() throws Exception{
        RandomAccessFile  readAcessFile=new RandomAccessFile("resource/test.txt","r");//创建RandomAccessFile文件对象时，传入一个r参数（r即readonly）代表该文件对象只可以执行read操作，不能写入
        /**
         * 如下操作，read成功，write失败，因为该对象是只读对象过
         */

        System.out.println(readAcessFile.read());;//read可以
        //readAcessFile.write(97);//write失败  抛出（java.io.IOException: Bad file descriptor）错误的文件描述符
        readAcessFile.close();//关闭流
    }

    /**
     * 测试RandomAcessFile的RW模式
     * 该模式意思是RW，（read & write），意思是可以对文件进行读写操作，但是不立即写入更改到文件中，数据是放入缓存的，除非close或者强制清空缓存
     * @throws Exception
     */
    @Test
    public void testRandomAcessFileRWMode() throws Exception{
        RandomAccessFile  writeAcessFile=new RandomAccessFile("resource/test.txt","rw");//创建RandomAccessFile文件对象时，传入一个rw参数（rw即read & write）代表该文件对象可以执行read操作和write操作
        /**
         * 如下操作，read和write都可以成功
         */

        System.out.println(writeAcessFile.read());;//read可以读出文件中的开头第一个字节数据
        writeAcessFile.seek(writeAcessFile.length());//设置从哪个位置开始写入数据(指的是从文件末尾写入数据，也就是意味着追加内容，而不是覆盖)，如果没有设置，则每次是从文件开头写入数据
        writeAcessFile.write(97);//write可以
        System.out.println("执行了write动作，还没有close");
        Thread.sleep(20000);

        writeAcessFile.close();//关闭流

    }

    /**
     * 测试RandomAcessFile的RWD模式
     * RWD -意思是read write data（即每次对文件的写入操作只是立即更新数据到文件中，但是不会更新文件你的描述信息（其实就是文件的修改时间））
     * 知道流关闭才将文件的描述信息更新
     * @throws Exception
     */
    @Test
    public void testRandomAcessFileRWDModel()throws Exception{
        RandomAccessFile  writeAcessFile=new RandomAccessFile("resource/test.txt","rwd");

        System.out.println(writeAcessFile.read());//读取文件中第一个字节数据
        writeAcessFile.seek(writeAcessFile.length());//指向到末尾写入数据
        writeAcessFile.write(65);
        System.out.println("执行了write动作，还没有close");
        Thread.sleep(20000);
        writeAcessFile.close();


    }

    /**
     * 测试RandomAcessFile的RWS模式
     * RWS -意思是read write synchornized（即每次对文件的写入操作立即更新数据和文件描述到文件中（其实就是文件的修改时间））
     * @throws Exception
     */
    @Test
    public void testRandomAcessFileRWSModel()throws Exception{
        RandomAccessFile  writeAcessFile=new RandomAccessFile("resource/test.txt","rws");
        System.out.println(writeAcessFile.read());//读取文件中第一个字节数据
        writeAcessFile.seek(writeAcessFile.length());//指向到末尾写入数据
        writeAcessFile.write(65);
        System.out.println("执行了write动作，还没有close");
        Thread.sleep(20000);
        writeAcessFile.close();




    }


}
