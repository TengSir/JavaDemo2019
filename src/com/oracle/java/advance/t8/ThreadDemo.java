package com.oracle.java.advance.t8;

/**
 * 多线程创建方式和运行案例演示
 */
public class ThreadDemo {

    public static void main(String[] args) {


        /**
         * 线程创建两种方式
         * 1。继承Thread类，覆盖run方法
         */
        Thread t1=new MyThread1();
        Thread t2=new MyThread2();

        //启动线程是调用线程的start方法，
        t1.start();

        t2.start();

        /**
         * 2.可以类实现runnable接口，覆盖run方法
         */
        Runnable  r=new MyThread3();
        Thread  t3=new Thread(r);

        t3.start();

        /**
         * 3.匿名内部类实现线程
         */
        new Thread(){
            @Override
            public void run() {
                for(int n=0;n<3;n++){
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("@555555555555555");
                }
            }
        }.start();


        for(int n=0;n<3;n++){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("@111");
        }
    }
}

class MyThread1 extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       for(int n=0;n<3;n++){
           try {
               Thread.sleep(200);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println("$222222");
       }
    }
}

class MyThread2 extends Thread{
    @Override
    public void run() {
        for(int n=0;n<3;n++){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("#33333333");
        }
    }
}
class MyThread3 implements  Runnable{

    public void run() {
        for(int n=0;n<3;n++){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("?444444444444");
        }
    }
}