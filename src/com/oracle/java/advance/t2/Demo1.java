package com.oracle.java.advance.t2;

/**
 * ���븴��
 * @author tengsir
 *
 */
public class Demo1 {
	int age=222;//��ʼ������2
	public Demo1() {//3���ù������Ĵ���
		System.out.println(age);//222
		age=333;
	}
	public static void main(String[] args) {
		Animal d=new Twoha();
		
		Dog d1=(Dog)d;
		
		Twoha  ttt=(Twoha)d;
		
		
		Animal  dd=d;//����ת�ͣ���̬��ʽ����һ������dd��
		
		System.out.println(d instanceof Dog);
		System.out.println(d instanceof Animal);
		System.out.println(d instanceof Twoha);
		
		
		
		Animal  a=new Cat();//
		
		
		Cat  cc=(Cat)d;//����ת�ͣ�Ϊ���ܹ����þ������͵����ⷽ��
		cc.catchMouse();
		
		a=new Dog();//��̬�﷨������java����
		a.sleep();//4 hours
		a.eat();
		
		a=new Cat();
		a.sleep();//20 hours
		
//		Demo1 d1=new Demo1();
//		Dog d=new Dog();
//		d.eat();
//		d.age=6;
//		d.speakType="wangwangwang";
//		Cat c=new Cat();
//		c.age=3;
//		c.color="����ɫ��";
		
		Bike bbb=new Bike();
		MotorBike  mb=new MotorBike();
		FlyCar  fc=new FlyCar();
		Driver dri=new Driver();
		dri.drive(bbb);
		dri.drive(mb);
		dri.drive(fc);
	}

}
class Animal{
	int age;
	String sex;
	public void eat() {
		System.out.println("eat something");
	}
	public  void sleep()throws RuntimeException {
		System.out.println("sleep  8 hours");
	}
}
class Dog extends Animal{
	String speakType;
	public  void sleep()throws RuntimeException {
		System.out.println("sleep  4 hours");
	}
	 public  void sleep(int time){
		System.out.println("sleep  "+time+" hours");
	}
	 
	 public void  lookDoor() {
		 System.out.println("kanmen");
	 }
}
class Twoha extends Dog{
	public void chaijia() {
		System.out.println("���");
	}
}
class Cat extends Animal{
	String color;
	public  void sleep()throws RuntimeException {
		System.out.println("sleep  20 hours");
	}
	public void catchMouse() {
		System.out.println("catch a big mouse");
	}
}
class TrafficTool{
	public void work() {}
}
class Bike extends TrafficTool{}
class MotorBike extends TrafficTool{}
class Car extends TrafficTool{}
class Truck extends TrafficTool{}
class SUV extends TrafficTool{}
class FlyCar extends TrafficTool{}


class Driver{
	public void drive(TrafficTool b) {
		b.work();
	}
	
}