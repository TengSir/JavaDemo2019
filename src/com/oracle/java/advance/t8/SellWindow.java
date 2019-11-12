package com.oracle.java.advance.t8;


import java.util.Random;

public class SellWindow extends Thread {
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
