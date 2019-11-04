package com.oracle.java.advance.t3;

//java���еĳ�Ա�����У����ԣ���������ͨ�����͹��췽����������飨��̬���;�̬��
public class Demo2 {
	
	int age;
	public void change() {
		
	}
	/**
	 * ��̬�����
	 */
	static {
		System.out.println("�����Ƕ����һЩ����ع����еĳ�ʼ������1");
	}
	static {
		System.out.println("�����Ƕ����һЩ����ع����еĳ�ʼ������2");
	}
	static {
		System.out.println("�����Ƕ����һЩ����ع����еĳ�ʼ������3");
	}
	static {
		System.out.println("�����Ƕ����һЩ����ع����еĳ�ʼ������4");
	}
	//��̬�����
	{
		System.out.println("��̬����죬������new����ʱ�ᱻִ�е�һ������飬����һ������дһЩ��ʼ������1");
	}
	{
		System.out.println("��̬����죬������new����ʱ�ᱻִ�е�һ������飬����һ������дһЩ��ʼ������2");
	}
	public Demo2() {
		System.out.println("����������ĳ�ʼ��");
	}
	public static void main(String[] args) {
		new Demo2();
	}

}
