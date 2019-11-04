package com.oracle.java.advance.t1;

import com.oracle.java.advance.t2.Demo3;

public class Demo1 extends Demo3 {
	String  name;
	char sex;
	int age;//ʵ������/���Ա���� ʵ��������Ĭ��ֵ
	public void change() {
		System.out.println(aaa);
		int aaa=12;//�ֲ�����
		int age=234;
		System.out.println(aaa);
		System.out.println(this.age);
	}
	public static void main(String[] args) {
		Demo3 u=new Demo3();
//		u.age=234;
//		u.aaa=123;
		//java��������  ��������/�������ͣ���������/�������ͣ�
		String name="aa";
		int age=234;
		char sex='f';
		//...
		
//		Student s=new Student('aa',234,'f');
		
	}

}
