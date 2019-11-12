package com.oracle.java.advance.t8;

import java.util.ArrayList;
import java.util.Random;

public class TestArrayList {
    public static void main(String[] args) {
        final ArrayList<Integer> nums=new ArrayList<Integer>();

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
