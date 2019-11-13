package com.oracle.java.advance.t8;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class ThreadSafeDemo {
    public static void main(String[] args) {
//        final Vector<Integer> nums=new Vector<Integer>();//Vector的add方法同步了，所以是线程安全的
        final ArrayList<Integer> nums=new ArrayList<Integer>();//ArrayList的add方法没有同步，所以是线程不安全的

        for(int n=0;n<10;n++){
            Thread t=new Thread(){
                @Override
                public void run() {
                   for(int m=0;m<100;m++){
//                       try {
//                           Thread.sleep(50);
//                       } catch (InterruptedException e) {
//                           e.printStackTrace();
//                       }
                       nums.add(new Random().nextInt());
                   }
                }
            };
            t.start();
            try {
                t.join(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(nums.size());
    }
}
