package com.oracle.java.advance.t9;

import lombok.*;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectOutputStreamDemo {
    public static void main(String[] args) throws Exception {
        /**
         * ObjectOutputStream这个流叫做对象输出流（可以写入一个对象到文件中）
         *
         * 另外一个叫法叫做序列化流：将内存中的一个java对象写入文件
         *
         * 它也是个过滤流（高级流），可以写入对象到文件
         *
         * 自定义的java类，如果想让这个类的对象被序列化（被保存到文件中）
         * 需要让该类实现java.io.serilizable接口（标识型接口，没有任何要实现的抽象方法）
         * 如果被序列化的类中含有其他自定义的类属性，则关联的这些类型都必须实现接口，否则无法序列化
         *
         * 如果某个类中的其中一个属性不希望它的值被保存下来，则应该使用过transient修饰（控制这个属性不被写入文件）
         */
        Teacher t=new Teacher("jack",new Class(),20,"male","english");

        ObjectOutputStream  out=new ObjectOutputStream(new FileOutputStream("resource/hhh.ser"));
        out.writeObject(t);
        out.close();

    }
}
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

class  Teacher implements Serializable {
    private String name;
    private Class c;
    private int age;
    private String sex;
    private    String teachCourse;
}

class  Class implements  Serializable{
    private String name;
}