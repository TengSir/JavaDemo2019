package com.oracle.java.advance.t3;

public class Demo1 {
	
	public static void main(String[] args) {
		//��̬���������౻����ʱ�Ѿ���ʼ���������ڴ沢��ֵ�ˣ�
		//��̬������Ϊ�����࣬����java�ṩ�ı�ע�����﷨Ӧ����  class.staicField (Obj.staticField)
		//�൱�еľ�̬��������������ʵ������������ʵ�������������þ�̬��������̬�����ȼ��ص��ڴ��ϣ�ʵ��������
		//��̬������Ҫ��ǰ���ص�stack�У����Ƿ����еı���ֻ�е���ʱ���ܷ���ռ䣨�����в����о�̬������
//		User.a=123;
		User u=new User();
		User u1=new User();
		u.a=123;
		User.b=234;
		u1.a=345;
		User.b=456;
		System.out.println(u.a);
		System.out.println(u.b);
		System.out.println(u1.a);
		System.out.println(u1.b);
		
		Father c=new Child();
		c.work();
	}
}

 class Father{
	public   void work() {
		System.out.println("father work some hours");
	}
}
class Child extends Father{
	public  void work() {
		System.out.println("father work 4 hours");
	}
}

class User{
	int a=b;
	static int b=123;
	String  name;
	public static void  method() {
	}
	public  void  change() {
	}
	public  void  other() {
		System.out.println(a);
		System.out.println(b);
		change();
		test();
	}
	public static void  test() {
//		System.out.println(this.a);
		System.out.println(b);
		method();
	}
}
