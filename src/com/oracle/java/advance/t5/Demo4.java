package com.oracle.java.advance.t5;

public class Demo4 {

    public static void main(String[] args) {
        new Test1(){
            @Override
            public void m2() {
                System.out.println("匿名 m2");
            }

            @Override
            public void m1() {
                System.out.println("m1 method");
            }


        }.m1();
//        new ArrayListDemo(){
//            @Override
//            public void test() {
//                System.out.println("test method");
//            }
//        }.test();
    }
}

interface  Test{
    public void  test();
}
abstract class Test1{
    public  abstract  void m1();
    public void m2(){
        System.out.println("method2 ");
    }
}
