package com.oracle.java.advance.t5;

import java.util.Objects;

/**
 * 自定义的类型，如果想比较这种类型两个对象内容是否一样，必须手动覆盖equals
 * 标记型接口
 */
public class Student implements  Cloneable{//full name  pathName-simpleName

    public Xueji getXj() {
        return xj;
    }
    public void setXj(Xueji xj) {
        this.xj = xj;
    }

    private Xueji xj;//Student Xueji property

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student obj=(Student)super.clone();
        obj.setXj((Xueji) xj.clone());
        return obj;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Xueji implements  Cloneable{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    private String suozaiji ;
    private String createTime;
    private String xxx;
    private String xxxx;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Xueji xueji = (Xueji) o;
        return Objects.equals(suozaiji, xueji.suozaiji) &&
                Objects.equals(createTime, xueji.createTime) &&
                Objects.equals(xxx, xueji.xxx) &&
                Objects.equals(xxxx, xueji.xxxx);
    }



    public Xueji(String suozaiji, String createTime, String xxx, String xxxx) {
        this.suozaiji = suozaiji;
        this.createTime = createTime;
        this.xxx = xxx;
        this.xxxx = xxxx;
    }

    public String getSuozaiji() {
        return suozaiji;
    }

    public void setSuozaiji(String suozaiji) {
        this.suozaiji = suozaiji;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getXxx() {
        return xxx;
    }

    public void setXxx(String xxx) {
        this.xxx = xxx;
    }

    public String getXxxx() {
        return xxxx;
    }

    public void setXxxx(String xxxx) {
        this.xxxx = xxxx;
    }
}
