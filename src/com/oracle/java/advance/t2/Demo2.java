package com.oracle.java.advance.t2;

public class Demo2 {

	public static void main(String[] args) {
		C b=new C();
	}
}
class A{
	public A(int a) {
		System.out.println("A ");
	}
	public A() {
		System.out.println("A no");
	}
}
class B extends A{
	public B() {
		this(10);
		System.out.println("B  no");
	}
	public B(int c) {
		super();
		System.out.println("B ");
	}
	
}
class C extends B{
	public C() {
	System.out.println("C");
	}
	
}