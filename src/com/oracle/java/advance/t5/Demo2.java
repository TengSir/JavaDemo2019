package com.oracle.java.advance.t5;

import java.io.IOException;

@SuppressWarnings("ALL")
public class Demo2 {
    public static void main(String[] args) {

        String s1="ttt";
        String s2="ttt";
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
        String s3=new String("ttt");
        //noinspection unused
        String s4=new String("ttt");
        System.out.println(s1==s3);
//        String specialWords="tmd";
        //noinspection unused
        Student sss=new Student(){};
        //noinspection unused
        StringBuffer  sb=new StringBuffer();//16
//        while(true) {
//
//            //read special word
//           sb.append("tmd");
//        }
    }
}
