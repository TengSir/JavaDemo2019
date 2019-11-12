package com.oracle.java.advance.t8;

/**
 * 中央数据库票资源
 */
public class Tiket {
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
