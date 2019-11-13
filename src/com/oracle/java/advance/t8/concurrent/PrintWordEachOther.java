package com.oracle.java.advance.t8.concurrent;

/**
 * 设计一个简单呢对程序，要求使用两个线程交替运行，打印出A,B,A,B,A,B,A,B,A,B,A,B......
 * 第一个线程打印A，第二个线程个打印B，如此交替
 */
public class PrintWordEachOther {
    public static void main(String[] args) {
        Printer  printer=new Printer();
        PrintAThread printAThread=new PrintAThread(printer);
        PrintBThread printBThread=new PrintBThread(printer);
        printAThread.start();
        printBThread.start();

    }
}
class Printer{
    private boolean isPrintA=true;
    public  synchronized  void printA(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(!isPrintA) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("A ");
        isPrintA=false;
        this.notifyAll();

    }
    public synchronized   void printB(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(isPrintA) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("B ");
        isPrintA=true;
        this.notifyAll();

    }
}
class PrintAThread extends Thread{
    private Printer printer;
    public PrintAThread(Printer printer){
        this.printer=printer;
    }
    @Override
    public void run() {
        for (int n=0;n<10;n++){
            printer.printA();
        }
    }
}
class PrintBThread extends Thread{
    private Printer printer;
    public PrintBThread(Printer printer){
        this.printer=printer;
    }
    @Override
    public void run() {
        for (int n=0;n<10;n++){
            printer.printB();
        }
    }
}