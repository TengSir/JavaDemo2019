package com.oracle.java.advance.t8;

/**
 * 多线程同时卖100张火车票的案例
 */
public class SellTickets {
    public static void main(String[] args) {
        Tiket t=new Tiket();

        SellWindow w1=new SellWindow(t,"A");
        SellWindow w2=new SellWindow(t,"N");
        SellWindow w3=new SellWindow(t,"C");
        SellWindow w4=new SellWindow(t,"D");
        SellWindow w5=new SellWindow(t,"E");
        w1.start();
        w2.start();
        w3.start();
        w4.start();
        w5.start();
    }
}

/**
 * 封装售票窗口线程类
 */
 class SellWindow extends Thread {
    public SellWindow(Tiket t,String name) {
        this.t = t;
        this.name=name;
    }

    private Tiket t;
    private String name;

    @Override
    public void run() {
        while(t.getTicketNo()<=100){

            t.sellTicket(name);
        }
    }
}

/**
 * 中央数据库票资源
 */
 class Tiket {
    private Object o=new Object();

    private int ticketNo=1;

    public synchronized void sellTicket(String windowName){

        if(ticketNo>100){
            System.out.println("当前车次车票已经售完！");
            return ;
        }
        System.out.println(windowName+"窗口卖出了"+ticketNo+"这张票");
        ticketNo++;
    }

    public int getTicketNo() {
        return ticketNo;
    }
}
