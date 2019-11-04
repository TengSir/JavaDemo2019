package com.oracle.java.advance.t3;

/**
 * abstract
 * ��abstract���ε������������
 * ��abstract���εķ����������󷽷�
 * @author tengsir
 */
public class Demo4 {
	public static void main(String[] args) {
//		Animal a=new Animal();
//		Dog d=new Dog();
//		d.eat();
	}

}

abstract  class Animal{
	public Animal() {
		System.out.println("���췽��");
	}
	String color;
	int age;
	float weight;
	  abstract  void eat();
	static final public   void sleep() {
		
	}
}
 class  Dog extends Animal{
	 String color;
		int age;
		float weight;
	@Override
	public void eat() {
		System.out.println("eat ��ͷ");
		
	}
	 
 }
 abstract class Cat extends Animal{
	 
 }