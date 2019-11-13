package com.oracle.java.advance.t8.concurrent;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * jdk5之后提出的线程池技术来提升用户可以手动编程式 的控制线程对象，并且提高线程对象的可利用性
 */
public class ThreadpoolDemo {
    public static void main(String[] args) {
        /**
         * jdk 5.0以前，线程是无法回收使用的，一次性的，所以，对于系统的开销还有资源的利用是很不合理的。
         * */
        String m="考研经典数学题";
        int count=10;
        PrintThread  p=new PrintThread(m,count);
        PrintThread1  p1=new PrintThread1(m,count);
        PrintThread1  p2=new PrintThread1(m,count);
        p.start();//启动线程，
        try {
            p.join();//让主线程等待该打印线程执行完毕
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //中间模拟又有其他一些业务代码
        System.out.println("other code");
      //p.start();//线程对象无法复用，执行完毕后，对象已经进入destroy状态，无法再次启动，会抛出  IllegalThreadStateException 异常


        /**
         * jdk 5.0可以使用线程池来管理用户的线程对象
         *
         * ExecutorService 是线程池接口
         *
         * Executors  是创建线程池对象的服务类，
         *
         * Executors.newCachedThreadPool();创建一个缓存的线程池对象，
         *
         * 使用线程池的话，一个创建好的线程对象可以反复放入线程池运行，大大提高一个对象的复用性
         */
        ArrayList<PrintThread1> pts=new ArrayList<>();
        pts.add(p1);
        pts.add(p2);

        ExecutorService  threadPool=Executors.newCachedThreadPool();//创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
        ExecutorService  threadPool1=Executors.newFixedThreadPool(4);//创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
        ExecutorService  threadPool2=Executors.newScheduledThreadPool(5);//创建一个定长线程池，支持定时及周期性任务执行。
        ExecutorService  threadPool3=Executors.newSingleThreadExecutor();//创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
        ExecutorService  threadPool4=Executors.newWorkStealingPool();//newWorkStealingPool适合使用在很耗时的操作，但是newWorkStealingPool不是ThreadPoolExecutor的扩展，它是新的线程池类ForkJoinPool的扩展，但是都是在统一的一个Executors类中实现，由于能够合理的使用CPU进行对任务操作（并行操作）
        threadPool.execute(p);//执行线程，但是不获取返回值
        threadPool.execute(p);
        Future f=threadPool.submit(p);//执行线程获取返回值
        threadPool.shutdown();//发起关闭信号，不接受新的线程运行，但是不强制关闭当前线程，等待当前线程执行结束(优雅停机)
        threadPool.shutdownNow();//立即关闭线程池所有线程
        try {
            threadPool.invokeAll(pts);//立即启动执行传入的集合里的所有线程的
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            threadPool.invokeAny(pts);//随机调用传入集合里的一个线程并运行它
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        // threadPool.
    }
}

/**
 * jdk5之前的线程定义方式
 */
class PrintThread extends  Thread{

    private String willPrintContent;
    private int count;

    public PrintThread(String willPrintContent,int count) {
        this.willPrintContent = willPrintContent;
        this.count=count;
    }

    @Override
    public void run() {
        for (int i = 1; i <=count; i++) {
            System.out.println("printMessage["+willPrintContent+"] on the paper [No. "+i+"]");

        }
    }
}

/**
 * jdk5之后新的api创建线程的方式
 */
class PrintThread1 implements Callable<Boolean> {

    private String willPrintContent;
    private int count;

    public PrintThread1(String willPrintContent,int count) {
        this.willPrintContent = willPrintContent;
        this.count=count;
    }

    public Boolean call() {
        for (int i = 1; i <=count; i++) {
            System.out.println("printMessage["+willPrintContent+"] on the paper [No. "+i+"]");

        }
        return true;
    }
}