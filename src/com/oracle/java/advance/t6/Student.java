package com.oracle.java.advance.t6;

import lombok.*;

import java.util.Comparator;

/**
 * lombok是一个java 一套类库（jar包）这套组件可以动态给类添加java封装思想中基本对各种常见成员（get和set，constructor，equals，hashcode，tostring）
 *
 * 意义在于，降低程序员对基础编码量，可以让你对源代码更加存粹，他是在编译阶段自动会在类中添加必须对类对成员
 *
 *
 * 在idea上如何使用lombok对我们对类提供动态生成基本成员对功能：
 * 1.打开idea-perferences-->plugins搜索lombok插件，搜索到了之后点击下面的install，安装完毕后要restart  idea软件
 *
 * 2.你的工程上必须依赖lombok的jar包，这里推荐使用maven（maven是帮们下载各种各种jar的）
 *    工程添加maven依赖后，在pom.xml中添加
 *       <dependency>
 *             <groupId>org.projectlombok</groupId>
 *             <artifactId>lombok</artifactId>
 *             <version>RELEASE</version>
 *         </dependency>
 *
 *  3.在你自己定义的java中，将属性封装好（属性私有化）
 *
 *  4.添加lombok注解（lombok动态生成get或者其他成员，全部是靠注解）
 *@Getter
 * @Setter
 * @AllArgsConstructor
 * @NoArgsConstructor
 * @ToString
 * @EqualsAndHashCode
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString




public class Student implements  Comparable<Student>{
    @Override
    public boolean equals(Object o) {
        System.out.println("计算出🈶一个对象的hash值和桶里面的另外一个对象的hash值一样了，此时需要再次调用equals做二次确认是否一样");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                high == student.high &&
                name.equals(student.name) &&
                sex.equals(student.sex) &&
                stuNo.equals(student.stuNo);
    }

    //hashcode的算法不可靠，只能保证对象的属性值完全一样是，hashcode的值绝对是一样的，但是无法保证，对象的属性值不一样的时候，hashcode的值是不一样的
    //由于hashcode算法是要靠所有的属性生成的数字合成一个综合的哈希数值，所以hash算法存在判断对象是否一样的不确定性
    //hashset采用了一个补充的方案来实现既可以继续使用hash算法来判重，又可以高效对自定义对象类型来判断。

    //hashset集合如何判断重复，对象添加时，第一步先调用对象的hashcode方法，生成对象的hash值，然后如果hash值一样的时候，需要再次调用equals方法做二次确认。

    //hashset存储自定义的java类型，该类型必须覆盖hashcode方法和equals方法

    @Override
    public int hashCode() {
        System.out.println("调用了hashcode算法，生成该对象hash码");
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + high;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((sex == null) ? 0 : sex.hashCode());
        result = prime * result + ((stuNo == null) ? 0 : stuNo.hashCode());
        System.out.println("调用了hashcode算法，生成该对象hash码"+result);
        return result;
    }

    private String name;
    private String sex;
    private int age;
    private int high;
    private String stuNo;
    public void work(){}
    private void eat(){}
    private void sleep(){}

    public void bijiao(){

    }

    public int compareTo(Student o) {
        if(this.age==o.getAge()){
            return this.name.compareTo(o.getName());
        }else {
            return this.age - o.getAge();
        }
    }
}
//Collections.sort 排序的时候他会拿集合里的第一个对象和第二个对象比较

class StudentHighComparator  implements Comparator<Student>{

    public int compare(Student o1, Student o2) {
        return o1.getHigh()-o2.getHigh();
    }
}


class StudentNameComparator  implements Comparator<Student>{

    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }
}