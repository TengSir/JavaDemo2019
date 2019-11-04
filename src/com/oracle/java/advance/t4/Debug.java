package com.oracle.java.advance.t4;

//debug�����ԣ������������Աһ�����Ĳ鿴����ִ�в��裬��ϸ�˽����ִ�й��̣����Ҵ���
//��ϵ㣬breakpoint
public class Debug {
	
	public static void change() {
		int a=20;
		
		int b=11;
		int result=1+(a++)+b;
		System.out.println(a);
		System.out.println(result);
		
	}
	public static void main(String[] args) {
		change();
	}

}
