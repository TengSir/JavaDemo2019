package com.oracle.java.advance.t8;

import java.util.Random;

public class ThreadDeadLock {
    public static void main(String[] args) {
        /**
         * 线程死锁现象发生在，两个线程互逆的抢占两个锁
         */
        Resource  resource=new Resource();
        IncreaseThread  i=new IncreaseThread(resource);
        ReduceThread r=new ReduceThread(resource);
        i.start();
        r.start();

    }
}
class Resource{
    private Integer num=0;
    private Integer count=0;
    private Object lock1=new Object();
    private Object lock2=new Object();

    public void  addNum(int increaseNum){
        synchronized (lock1){
            System.out.println("线程在对数字执行加法之前需要先获取num的锁");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num+=increaseNum;
            synchronized (lock2){
                count++;
                System.out.println("加完之后，需要增加对数值对修改次数，需要获得count的锁");
            }
        }
    }
    public void  removeNum(int reduceNum){
        synchronized (lock2){
            System.out.println("线程在对数字执行减法之前需要先获取count的锁，显示对数值对修改次数");
            try {
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;

            synchronized (lock1){
                num-=reduceNum;
                System.out.println("然后需要获得num的锁，然后对数值进行修改。");
            }
        }
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
//            try {
//                Thread.sleep((new Random().nextInt(10)+1)*100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
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
//            try {
//                Thread.sleep((new Random().nextInt(10)+1)*100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            resource.removeNum(new Random().nextInt(100));
        }
    }
}