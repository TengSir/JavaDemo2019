package com.oracle.java.advance.t8.concurrent;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * jdk5.0后提供的新的并发包中的Lock接口定义了tryLock方法，运行
 */
public class ProcessThreadDeadLock {
    public static void main(String[] args) {
        /**
         * 线程死锁现象发生在，两个线程互逆的抢占两个锁
         */
        Resource resource=new Resource();
        IncreaseThread i=new IncreaseThread(resource);
        ReduceThread r=new ReduceThread(resource);
        i.start();
        r.start();

    }
}

class Resource{
    private Integer num=0;
    private Integer count=0;
    private Lock  lock1=new ReentrantLock();
    private Lock  lock2=new ReentrantLock();

    public void  addNum(int increaseNum){
            lock1.lock();
            System.out.println("+++++，获得lock1的锁");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num+=increaseNum;
             System.out.println("+++++,加完之后num="+num);
               if( lock2.tryLock()) {
                   count++;
                   System.out.println("加法成功后，获得lock2的锁，对count执行加一,count="+count);
                   lock2.unlock();
               }
             System.out.println("\r\n");
            lock1.unlock();

    }
    public void  removeNum(int reduceNum){
        lock2.lock();
            System.out.println("-----,获得lock2的锁");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            System.out.println("-----,减法执行前count="+count);
                if(lock1.tryLock()) {
                    num -= reduceNum;
                    System.out.println("count加一后，获得lock1的锁，对num执行减法,num="+num);
                    lock1.unlock();
                }
            System.out.println("\r\n");
            lock2.unlock();
    }
}

class IncreaseThread extends  Thread{
    private Resource resource;
    public IncreaseThread(Resource resource){
        this.resource=resource;
    }

    @Override
    public void run() {
        while(true){
            resource.addNum(new Random().nextInt(100));
        }
    }
}

class ReduceThread extends  Thread{
    private Resource resource;
    public ReduceThread(Resource resource){
        this.resource=resource;
    }

    @Override
    public void run() {
        while(true){
            resource.removeNum(new Random().nextInt(100));
        }
    }
}