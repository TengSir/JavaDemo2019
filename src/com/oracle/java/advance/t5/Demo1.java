package com.oracle.java.advance.t5;

public class Demo1 {
    public static void main(String[] args)throws Exception {
        //getClass是获取一个对象的真是类型（完整类型名）
        //equals，object设计时是为了让大家方便调用这个方法来比较对象的内容是否相等
        //但是如果用户自己定义的类型没有覆盖该方法，则比较内存地址，所以如果要比较内容则需要手动覆盖

        //toString当输出一个对象当信息时默认会调用的方法，用户u手动覆盖，将对象的属性拼接成一个字符串

        //clone克隆,直接在内存上复制一个新对象，和愿对象的内容一摸一样，但是内存地址不一样，是一个新对象，比new运算符创建对象过要快

        //clone分为浅克隆 ，和深克隆(存在实际复杂情况，导致克隆的复杂比较高，所以，考虑实际需要用到的数据才做相应的深克隆)
//        Object ages=new int[10];//数组属于引用类型（对象类型）
//        Object name=new String("tengsir");
//        System.out.println(ages.getClass());
//        System.out.println(name.getClass());

        Xueji xj=new Xueji("henan","2009-10-12","xxx","23423");
        Student s1=new Student("jack",18);
        s1.setXj(xj);
        Student s5=(Student)s1.clone();

        System.out.println(s1.equals(s5));


        System.out.println(s1==s5);

        System.out.println(s1.getXj().equals(s5.getXj()));

        System.out.println(s1.getXj()==s5.getXj());
//        Student s2=new Student("rose",16);
//        Student s3=new Student("tom",22);
//        Student s4=new Student("jack",18);
//
//        System.out.println(s2.toString());
//        System.out.println(s1.equals(s4));
//        System.out.println(s1.equals(null));
//        System.out.println(s1.equals(ages));
//        System.out.println(s1.equals(s1));
//        System.out.println(s1.equals(s4));
    }
}
