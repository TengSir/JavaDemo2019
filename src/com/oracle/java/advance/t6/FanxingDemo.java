package com.oracle.java.advance.t6;

import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
public class FanxingDemo {

    //泛型有两种用途
    //1.放在集合中使用是为了保证集合的类型安全
    //2.放在类或者接口上使用，是为了体现java程序设计的更高的灵活性 （泛型类）


    //泛型是保证集合里面的数据安全的，强制要求集合里只能放什么类型的数据

    //泛型没有多态
    //使用了泛型，再使用迭代器或者foreach循环时，拿到每个元素直接就是本类型，不再是object
    //java在运行时会将泛型类型擦除，泛型是属于编译型语法，运行时是没有泛型的
    @Test
    public void test(){
        ArrayList<Integer> nums=new ArrayList<Integer>();
        nums.add(234);
        nums.add(2);
        for(Integer o:nums){

        }
        Iterator<Integer> ns=nums.iterator();

        Set<Student> studentSet  =new HashSet<Student>();

    }
    @Test
    public void testClass(){
        Worker w1=new Worker();
        w1.setWorkNo("2001123123");
        Worker<Integer> w2=new Worker<Integer>();
        w2.setWorkNo(232432);

    }
}

@Getter
@Setter
class Worker<E>{
    private E workNo;
}
