package com.oracle.java.advance.t8.concurrent;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.*;
public class CallableDemo {
    public static void main(String[] args) {
        /**
         * jdk5.0更新对新对并发包里面改善了原有对线程api，提供了新对Callable接口，
         * 可以在线程执行完之后获得线程方法对返回值。
         */
        int[] datas=new int[10];
        for (int x=0;x<datas.length;x++) {
            datas[x]=new Random().nextInt(100);
        }
        System.out.println(Arrays.toString(datas));
        CalcThread  c=new CalcThread(datas);

        ExecutorService  pool= Executors.newSingleThreadExecutor();

        Future<Integer> result=pool.submit(c);
        pool.shutdown();
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class  CalcThread implements Callable<Integer> {
    private int[]  datas;
    public CalcThread(int[] datas){
        this.datas=datas;
    }
    @Override
    public Integer call() throws Exception {
        int sum=0;
        for (int x:datas) {
            sum+=x;
        }
        return sum;
    }
}