package com.oracle.java.advance.t6;

import lombok.*;
import org.junit.Test;

import java.util.*;

/**
 *Set集合默认特性是无序（不维持用户添加时元素的顺序），不可排序（只有hashset），不可重复（重复元素无法添加进去）
 *
 * Set的常见实现类是HashSet
 */
public class SetDemo {

    @Test
    public void testHashSet(){
        //迭代器用来专门输出集合数据的一个工具类，具有一次性，单向不可逆
        //hashset集合添加新对象时如果，该对象和集合里现有的数据重复，则add方法不执行，返回false
        Set  names=new HashSet();
        names.add("jack");
        names.add("rose");
        names.add("tom");
        names.add("jackson");
        names.add("jackson");

        Iterator  it=names.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("------");

    }
    @Test
    public void testhashSetForObject(){
        Student s1=new Student("jack","male",20,175,"201901");
        Student s2=new Student("rose","female",18,165,"201902");
        Student s3=new Student("tom","male",25,180,"201999");
        Student s4=new Student("toms","male",25,180,"201999");
        Set stus=new HashSet();
        stus.add(s1);
        stus.add(s2);
        stus.add(s3);
        stus.add(s4);
        Iterator<Student> it=stus.iterator();
        while(it.hasNext()){
            Student s=it.next();
            System.out.println(s.getName()+","+s.getSex());
        }
    }

    /**
     * TreeSet是SortedSet的实习类
     * 他是set系列中可以自动排序的一个集合，同样它具备不能重复特性
     * 自定义类型要求类必须实现comprable接口，覆盖里面的compareTo方法，该集合是靠判断这个方法的返回值是否为零来判断是否重复的，
     * 如果不为零，是靠返回的值是正负来判断顺序的
     */
    @Test
    public void testTreeSet(){
        SortedSet  nums=new TreeSet(new Comparator<Teacher>() {
            public int compare(Teacher o1, Teacher o2) {
                return 0;
            }
        });
//        nums.add(23);
//        nums.add(234);
//        nums.add(11);
//        nums.add(767);
//        nums.add(26);
        Teacher t=new Teacher("张老师",11);
        Teacher t1=new Teacher("张老师",11);
        Teacher t2=new Teacher("wang老师",22);
        nums.add(t);
        nums.add(t1);
        nums.add(t2);
        Iterator it=nums.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
}
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
class  Teacher {
    private String name;
    private int age;

}
