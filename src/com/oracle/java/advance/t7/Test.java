package com.oracle.java.advance.t7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * java中的异常处理方式，分为两种
 * 1.被动式
 * 在具体发生异常的位置，如果由于业务条件不合适或者需要异常集中处理的原因，则可以采用被动式，抛出去，让调用者方法来对该异常进行一定的处理。
 * 声明抛出异常也是一种必要的处理手段，并不是由于不处理而不合适使用。
 *
 *
 * 2.主动式
 * 遇到异常直接使用try-catch对异常在具体位置直接处理掉（最好采用这种方式）
 * try结构的可变形式
 *
 * try{}catch(Exception e){}
 * try{}catch(Exception e){}catch(NullpinterException e){}
 *
 * try后面如果跟多个catch，后面的catch块里面的处理的异常的类型应该是从小到大（从细到粗）
 *
 *finally是try-catch快必须会执行的一个结构，用来书写哪些希望在try里面的代码执行后一定要执行的业务代码，比如说关闭资源之类的
 *
 * try-catch-finally
 *
 * try-catch
 *
 * try-catch-catch
 *
 * try-catch-finally
 * try-catch-catch-finnally
 *
 * try-finally
 *
 *方法重写中，子类覆盖父类方法，可以抛出的异常应该小于等于父类可以抛出的异常，或者没有
 *
 *
 * java代码中可以使用throw关键字主动抛出一个异常对象
 * throw new Exception();//手动抛出一个异常
 */
public class Test {
    class Father{
        public void test()throws FileNotFoundException{}
    }
    class Son extends Father{
        public void test(){}
    }

    public static void main(String[] args)  {
        test();

        try {
            System.out.println("该代码运行不了，到此有风险");
            for (; ; ) {
                System.out.println("testst");
                //法律
            }
        }catch(Exception e) {
        }finally {

        }
    }

    public static void test(){
        System.out.println("test");
        test1();
    }
    public static void test1() throws ArithmeticException{
        System.out.println("test1");
        System.out.println(10/0);
        System.out.println("adadada");
        System.out.println("adasd");
    }
}
