package com.oracle.java.advance.t5;

public class Outter {
    private static int age=222;
    public void method(){
        Inner  i=new Inner();
        i.method();
        //i.aaa=234;
    }
    static class StaticInner{
        int age;
        static int ccc;
        public  static void change(){
            Outter.age=234;
        }
    }
    //直接定义在一个外围类里面的类就叫做成员内部类
    public    class Inner{

        private  int age=333;
        public  void method(){
            int age=444;
            System.out.println(this.age);
            System.out.println(Outter.this.age);
            System.out.println("do something");
        }
        public Inner(){
        }
    }





    public void  doSomething( final int aaaa){
         final int someNun=234;


        class AAA implements  Cloneable{
            private int age=someNun;

            public void test() {
                System.out.println(aaaa);
                System.out.println(someNun);
            }
                public AAA(){

                }
        }

        AAA a=new AAA();
        a.age=222;
        a.test();;

    }
}