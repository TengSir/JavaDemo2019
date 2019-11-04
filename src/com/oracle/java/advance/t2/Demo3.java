package com.oracle.java.advance.t2;
/**
 * java�ĸ��������η�
 * private����private���εĳ�Աֻ���ڱ���ʹ�ù�
 * default(ȱʡ)��default���εĳ�Ա���ʼ�������ͬһ�������棨�������ࣩ
 * protected:protected���εĳ�Ա��֮Ϊ���༶�𣨱�����Է��ʣ�����������Ҳ���Է��ʣ��������е���ֻ�����ࣨ�̳������ࣩ���Է��ʣ�
 * public:���еط������Է���
 * @author tengsir
 *
 */
public class Demo3 {
	 String name;
	 protected int aaa;
	public static void main(String[] args) {
		User u=new User();
//		u.age=234;
		u.name="234";
	}

}

 class User{
	private int age;
	 String name;
	int b=age;
	public void test() {
		System.out.println(age);
	}
	
}
