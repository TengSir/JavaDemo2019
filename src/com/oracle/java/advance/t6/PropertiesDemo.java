package com.oracle.java.advance.t6;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {

    /**
     * Properties继承了hashTable，所以它本质上也是一个key-value集合，
     * 但是它的名字命名为 'properties（属性）'，意思就是这个集合往往用来存储项目中的一些配置参数
     * 它里面集成了一个简单的使用io流从配置文件中快速读取配置参数的方法
     *
     *
     * 一句话总结，Properties就是可以快速读取xxx.properties文件里面的配置参数数据的一个键值集合
     */
    @Test
    public void testProperties(){

        Properties  props=new Properties();
        try {
            props.load(new FileInputStream("config/Database.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Set  keys =props.keySet();
        for(Object k:keys){
            System.out.println(k+"="+props.get(k));
        }


    }}
