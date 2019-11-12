package com.oracle.java.advance.t6;

import lombok.*;
import org.junit.Test;

import javax.swing.text.html.parser.Entity;
import java.util.*;

public class MapDemo {

    @Test
    public void testHashMap(){
        Map  m=new HashMap();

        Role r1=new Role("猪八戒",30);
        Role r2=new Role("沙和尚",40);
        Role r3=new Role("真孙悟空",600);
        Role r4=new Role("唐僧",20);
        Role r5=new Role("假孙悟空",20);

        Actor  a1=new Actor("周逸伦",18);
        Actor  a2=new Actor("赵正",18);
        Actor  a3=new Actor("何东东",18);
        Actor  a4=new Actor("刘韦佳",18);
        m.put(r1,a1);
        m.put(r2,a2);
        m.put(r3,a3);
        m.put(r4,a4);
        m.put(r5,a3);

//        m.put("key1","value1");
//        m.put("key2","value2");
//        m.put("key3","value2");
//        m.put("key1","value4");
        System.out.println(m.size());
        System.out.println(m.get("key1"));
        System.out.println(m.get("key2"));
        System.out.println(m.get("key3"));



        //Map集合如果要便利所有的值，应该调用集合的Values方法，该方法返回这个map集合的所有值，返回的是一个新的单值集合

        Collection  vs=m.values();
        for(Object o:vs){
            System.out.println(o);
        }

        System.out.println("00000000000");
        Iterator it=vs.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        //Map集合如果要便利所有的key，调用集合的keyset方法，返回一个新的set集合里面包含了所有的key
        Set  keys=m.keySet();
        for(Object O:keys){
            System.out.println(O);
        }

        //如果要成对对便利集合中对key和value，则可以采用两种方式，
        //1.便利key，再使用Map集合的get方法获取key对应的值
        Set  keyss=m.keySet();
        for(Object O:keyss){
            System.out.println(O+"="+m.get(O));
        }
        //2.使用集合的entrySet方法获取集合的键值对对应对Entry
        Set<Map.Entry>  es=m.entrySet();

        for(Map.Entry  e: es){
            System.out.println(e.getKey()+"="+e.getValue());
        }
    }



    @Test
    public void testTreeMap(){
        Map  m=new TreeMap();

        Role r1=new Role("猪八戒",30);
        Role r2=new Role("沙和尚",40);
        Role r3=new Role("真孙悟空",600);
        Role r4=new Role("唐僧",20);
        Role r5=new Role("假孙悟空",20);

        Actor  a1=new Actor("周逸伦",18);
        Actor  a2=new Actor("赵正",18);
        Actor  a3=new Actor("何东东",18);
        Actor  a4=new Actor("刘韦佳",18);
        m.put(r1,a1);
        m.put(r2,a2);
        m.put(r3,a3);
        m.put(r4,a4);
        m.put(r5,a3);

        System.out.println(m.size());
        Set  keyss=m.keySet();
        for(Object O:keyss){
            System.out.println(O+"="+m.get(O));
        }
    }

    /**
     * HashMap和HashTable的区别
     * 相同点，都是key-value型的键值对集合，而且集合的增删改，便利方法都一样
     *
     * 不同点，hashmap是线程不安全的，速度快，轻量级，hashtable是线程的安全的，速度慢，重量级别,hashtable的key不允许是null，但是hashmap的key可以有最多一个null
     */
    @Test
    public void testHashTable(){
    Map m1=new HashMap();
    m1.put("1","23");
    m1.put(null,"232");
    m1.put(null,"232");
    m1.put("1","2334");

    Map m2=new Hashtable();
    m2.put("12","234");
    m2.put(null,"234");
    }
}
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
class Role implements Comparable<Role>{
    public int compareTo(Role o) {
        if(this.age==o.getAge()){
            return this.name.compareTo(o.getName());
        }else{
            return this.age-o.getAge();
        }
    }

    private String name;
    private int age;
}
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
class Actor{
    private String name;
    private int age;
}