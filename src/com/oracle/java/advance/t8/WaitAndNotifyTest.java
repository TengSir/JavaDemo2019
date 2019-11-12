package com.oracle.java.advance.t8;

public class WaitAndNotifyTest {
    public static void main(String[] args) {
        BreadResonp b=new BreadResonp();
        Producer  p=new Producer(b);
        Consumer  c=new Consumer(b);
        p.start();
        c.start();


//        Object o=new Object();
//        try {
//            o.wait();//1.让当前线程睡眠 //2。它一定要释放当前线程持有的o对象的锁
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
