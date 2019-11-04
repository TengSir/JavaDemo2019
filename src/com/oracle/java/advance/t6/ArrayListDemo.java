package com.oracle.java.advance.t6;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

/*
junit   java unit  单元测试框架
 */
public class ArrayListDemo
{
    /**
     * ArrayList是list接口的一个实现类，是一个集合（容器）用来存储对象的
     * add
     * remove
     * size
     * isEmpty
     * contains
     * indexOf
     * get
     *
     *
     * 对ArrayList对数据便利有两种方式
     * 1.foreach（增强型for循环），在foreach循环中不能对集合做删除操作
     * 2.iterator迭代器
     *
     *
     *
     * java中如果要对arraylist排序请使用集合的帮助类（Collections这个类是集合帮助类，里面提供了很多更集合相关的业务方法）
     * 对arraylist排序使用Collections类中对sort方法就可以对集合自动排序
     *
     *
     *
     * ArrayList里面装的如果是自定义的类型的对象，如果要排序需要使用Collections。sort方法来排序，但是要求类里面必须实现Comparable接口里面的CompareTo方法。
     *
     * 如果需要额外添加其他属性排序器，则需要手动定义新的排序类，实现Comparator接口，覆盖里面的compare方法，
     *
     *
     * 1.类上面实现Comparable接口这种排序规则应该是最常用的排序规则
     *
     * 2.不经常使用，但是需要提供的给用户的排序规则，应该额外自定义类实现Comparator接口。
     *
     *
     *
     * List常见实现类 LinkedList，ArrayList有的方法，这个类全都有，但是它还实现了QUeue，所以本质上个它还可以充当队列，fifo，
     */

    /**
     * 这是测试ArrayList功能的测试方法
     */
    @org.junit.Test
    public void testArrayList(){
        java.util.ArrayList a=new java.util.ArrayList();
        a.add(123);
        a.add(234);
        a.add(345);
        a.add(456);
        a.add(1,999);
        a.remove(new Integer(456));
        a.contains(345);
        a.size();
        a.isEmpty();
        a.iterator();

        for(Object o:a){
            System.out.println(o);
            if(Integer.parseInt(o.toString())==123){
                a.remove(new Integer(123));
            }
        }


    }

    /**
     * 演示java集合存储自定义对象的功能
     * 自定义的java类型如果存储在ArrayList中，是不能直接调用COllections的sort方法，因为COllections类无法知道应该如何排序
     */
    @org.junit.Test
    public void testArrayListOfStudent(){
        Student s1=new Student("jack","male",20,175,"201901");
        Student s2=new Student("rose","female",18,165,"201902");
        Student s3=new Student("tom","male",25,180,"201999");
        Student s4=new Student("lucy","female",16,166,"201912");
        Student s5=new Student("lucy1","female",16,199,"201956");
        Student s6=new Student("lucy2","female",22,187,"201922");
        Student s7=new Student("lucy3","female",25,176,"201987");
        java.util.ArrayList a=new java.util.ArrayList();
        a.add(s1);
        a.add(s2);
        a.add(s3);
        a.add(s4);
        a.add(s5);
        a.add(s6);
        a.add(s7);
        for(Object o:a){
            System.out.println(o.toString());

        }
        System.out.println("------");
        Collections.sort(a);

        for(Object o:a){
            System.out.println(o.toString());

        }
    }

    /**
     * java中的ArrayList如果存储的是8中基本类型和String的话，可以直接排序，因为8中基本类型和String都已经实现了排序的方法
     */
    @Test
    public void testSortBasicAndStringData(){
        ArrayList  nums=new ArrayList();
        for(int n=0;n<10;n++){
            nums.add(new Random().nextInt(1000));
        }
        for(Object o:nums){
            System.out.print(o+",");
        }

        Collections.sort(nums);
        System.out.println();
        for(Object o:nums){
            System.out.print(o+",");
        }
    }
    @Test
    public void testComparator(){
        Student s1=new Student("jack","male",20,175,"201901");
        Student s2=new Student("rose","female",18,165,"201902");
        Student s3=new Student("tom","male",25,180,"201999");
        Student s4=new Student("lucy","female",16,166,"201912");
        Student s5=new Student("lucy1","female",16,199,"201956");
        Student s6=new Student("lucy2","female",22,187,"201922");
        Student s7=new Student("lucy3","female",25,176,"201987");
        java.util.ArrayList a=new java.util.ArrayList();
        a.add(s1);
        a.add(s2);
        a.add(s3);
        a.add(s4);
        a.add(s5);
        a.add(s6);
        a.add(s7);
        for(Object o:a){
            System.out.println(o.toString());

        }
        System.out.println("------");
        Collections.sort(a,new StudentHighComparator());
        for(Object o:a){
            System.out.println(o.toString());

        }
        System.out.println("------");
        Collections.sort(a,new StudentNameComparator());
        for(Object o:a){
            System.out.println(o.toString());

        }
        System.out.println("------");
        Collections.sort(a, new Comparator<Student>() {
            public int compare(Student o1, Student o2) {
                return o1.getStuNo().compareTo(o2.getStuNo());
            }
        });
        for(Object o:a){
            System.out.println(o.toString());

        }
        System.out.println("------");
    }



    @Test
    public void testLinkedList(){
        Queue nums=new LinkedList();
        //peek返回头部第一个元素，但是不删除，poll返回头部第一个元素，同时删除它，offer,往队列的尾部添加一个新的元素
    }



    @Test
    public void testVector(){
        final Vector  nums=new Vector();//重量级，线程安全，速度慢
//        final ArrayList nums=new ArrayList();//轻量级，线程不安全，速度快
        for(int n=0;n<5;n++){
           new Thread(){
               @Override
               public void run() {
                   nums.add(new Random().nextDouble());
               }
           }.start();
        }
        try
        {
            Thread.sleep(2000);
        }catch (Exception e){

        }
        System.out.println(nums.size());

    }

}
