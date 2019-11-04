package com.oracle.java.advance.t4;

public class Demo {

	public static void main(String[] args) {
		System.out.println(Test.b);;
	}

}
interface Test{
	public static final int a=234;
	 String b="test";
	 void test();
}

 class Other implements Test{

	public  void test() {
		 
	 }
	
}
