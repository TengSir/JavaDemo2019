package com.oracle.java.advance.t8;

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