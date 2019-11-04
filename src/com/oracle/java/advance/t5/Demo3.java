package com.oracle.java.advance.t5;

public class Demo3 {
    Integer  age;//实例变量

    public static void main(String[] args) {
        Provider  p=new Provider();
        Provider.Heart  h=p.new Heart();

        Outter   o=new Outter();
        Outter.Inner  in=o.new Inner();
        in.method();
        //in.aaa=3423;
        //System.out.println(in.aaa);

        Demo3 d=new Demo3();
        System.out.println(d.age);
       //java为每种基本类型提供了一个包装类，包装类主要解决类型类型之间 转化问题
        String num="234";
        Integer num1=new Integer("345");
        int num2=456;

        //String--->基本类型
        int nn6=Integer.parseInt(num);

        //基本类型---》包装类型
        Integer nn=new Integer(num2);
        Integer nn1=Integer.valueOf(num2);
        //String-->包装类型
        Integer nn3=new Integer(num);
        Integer nn4=Integer.valueOf(num);
        //基本类型---》string类型
        String nn7=num2+"";
        String nn8=String.valueOf(num2);
        //包装类---》基本类型
        int nn2=num1.intValue();
        //包装类型---》String类型
        String nn5=num1.toString();


        //自动拆装箱是jdk5.0提供的简便语法，允许包装类型和基本类型可以直接互转
        Integer ccc=new Integer(444);
        int ddd=ccc;//自动拆箱
        Integer eee=ddd;//自动装箱
    }
}
