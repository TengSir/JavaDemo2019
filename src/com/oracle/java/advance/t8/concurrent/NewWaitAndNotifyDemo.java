package com.oracle.java.advance.t8.concurrent;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * jdk5.0以后提供了，可编程式的同步锁和等待通知机制
 * 提供了Lock锁（接口），里面有lock和unLock，以及tryLock方法
 * 提供了Condiction类，可以使用await和signal以及signalAll方法执行等待通知机制
 */
public class NewWaitAndNotifyDemo {
    public static void main(String[] args) {
            BreadResonp b=new BreadResonp();
            Producer p=new Producer(b);
            Consumer c=new Consumer(b);
            p.start();
            c.start();
    }
}

/**
 * 面包仓库，生产和消费同时对这个仓库操作 ，属于临界资源，多个线程同时要访问的公共资源
 */
 class BreadResonp {
    private Lock  lock=new ReentrantLock();
    private Condition  condition=lock.newCondition();
    private int count=0;
    public  void addBread(){
        lock.lock();//手动上锁
        if(count>=50)
        {
            System.err.println("仓库满了，生产者睡一会！");
            try {
                condition.await();//当线程应该停顿并释放锁的时候执行 await
                //1.wait可以跟sleep一样，使当前线程睡眠（阻塞）.wait永远睡眠，没人唤醒，永远不起来
                //2.wait释放当前线程持有的该对象的锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        nowCount("生产前");
        System.out.println("当前当前往仓库里存入一个刚刚生产的面包");
        count++;
        nowCount("生产后");


       condition.signalAll();//当需要唤醒该锁等待的其他线程时调用signalAll
        lock.unlock();//手动解锁
    }
    public void nowCount(String time){
        System.out.println(time+",   仓库里还有"+count+"个面包");
    }
    public    void removeBread(){
        lock.lock();//手动加锁
        if(count<=0)
        {
            System.err.println("仓库空了，消费者睡一会！");
            try {
                condition.await();;//主动睡眠，释放锁，给其他线程执行的机会
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        nowCount("消费前");
        System.out.println("当前从仓库里消费了一个面包！");
        count--;
        nowCount("消费后");

       condition.signalAll();//唤醒其他已经过睡眠释放锁的线程
        lock.unlock();//手动解锁
    }
}

/**
 * 封装一个生产者线程，该线程不停对往仓库里生产面包
 */
class Producer extends Thread{
    private BreadResonp b;
    public Producer(BreadResonp b){
        this.b=b;
    }

    @Override
    public void run() {
        System.out.println("生产者线程开始工作了");
        while(true){
            try {
                //模拟让当前线程睡眠随机时间，模拟出实际情况中过一会才能生产一个面包的情况
                Thread.sleep((new Random().nextInt(10)+1)*100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            b.addBread();//面包生产好了，调用仓库的add方法，将面包放入仓库
        }
    }
}

/**
 * 封装一个消费者线程，该线程不停的从仓库里消费面包
 */
class Consumer extends Thread{
    private BreadResonp b;
    public Consumer(BreadResonp b){
        this.b=b;
    }

    @Override
    public void run() {
        System.out.println("消费者线程开始工作了");
        while(true){
            try {
                //模拟让当前线程睡眠随机时间，模拟出实际情况中过一会才消费一个面包的情况
                Thread.sleep((new Random().nextInt(10)+1)*100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            b.removeBread();//消费者消费了一个面包，从仓库里移除一个面包
        }
    }
}


