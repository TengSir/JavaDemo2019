package com.oracle.java.advance.t1;
/**
 * ��һ�ַ������ֺ�������ȫһ�������Ƿ���û�з���ֵ����
 * ���췽�����������ڴ�������ʱִ��Ĭ�϶Գ�ʼ����Ϊ
 * @author tengsir
 *��һ�����й��췽�����Ե����������췽�����������ֻ�ܵ���������һ�����췽��
 *���ҵ����������췽������λ�ڵ�ǰ���췽���ĵ�һ�д���
 */
public class Constructor {
	int age;
	String name;
	double sex;
	/**
	 * @param age
	 * @param name
	 * @param sex
	 */
	public Constructor(int age, String name, double sex) {
		this(age,name);
		System.out.println("�в������췽��");
		this.age = age;
		this.name = name;
		this.sex = sex;
	}
	public Constructor(int age,String name) {
		this();
		System.out.println("�����������췽��");
		this.age = age;
		this.name = name;
	}
	public Constructor() {
		System.out.println("Ĭ�ϵĳ�ʼ������");
	}
	public static void main(String[] args) {
		Constructor  c1=new Constructor(123,"aaa",333);
//		Constructor  c1=new Constructor(123,"ttt",3423);
//		Constructor  c2=new Constructor(123,"",0);
//		Constructor  c3=new Constructor(123,"ttt");
//		System.out.println(c.a);
	}
}
