package com.oracle.java.advance.t6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionsDemo {

    @Test
    public void testCollections(){
        //Collections是集合帮助里，里面主要提供了一些对集合操作的常用方法，因为是帮助类（业务bean），方法大部分是static

        ArrayList names=new ArrayList();
        names.add("照正");
        names.add("qupeng");
        names.add("zhujinyu");
        names.add("zhuyinying");
        names.add("hedongdong");
        names.add("sunshanzhong");
        names.add("wuyanqing");
        names.add("yiyanzhong");
        Collections.shuffle(names);
        System.out.println(names.get(0));


    }
}
