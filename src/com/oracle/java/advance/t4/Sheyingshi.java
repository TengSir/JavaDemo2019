package com.oracle.java.advance.t4;

public class Sheyingshi {
	private String sex;
	private String name;
	private int year;
	private String title;
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @param sex
	 * @param name
	 * @param year
	 * @param title
	 */
	public Sheyingshi(String sex, String name, int year, String title) {
		super();
		this.sex = sex;
		this.name = name;
		this.year = year;
		this.title = title;
	}
	public void takePhoto(PhotoDevice d) {
		System.out.println("ѡ����");
		System.out.println("���ƹ�");
		d.work();
	}
	public static void main(String[] args) {
		Camera  c1=new DigitalCamera();
		Sheyingshi s=new Sheyingshi("��","����",3,"�ؼ���Ӱʦ");
		s.takePhoto(c1);
		
		Camera  c2=new DanFanCamera();
		
		s.takePhoto(c2);
		
		MeituMobile  meitu=new MeituMobile();
		
		s.takePhoto(meitu);
		
		RecordPen r=new RecordPen();
		
		s.takePhoto(r);
		
	}
}
interface PhotoDevice{
	public void work();
}

abstract   class Camera implements PhotoDevice{
	private String color;
	private double pixels;
	public void open() {System.out.println("��power����ͨ�磬����ϵͳ");}
	public void shutdown() {System.out.println("��power�����ϵ磬�ر�ϵͳ");}
	public abstract void work();
}
class DigitalCamera extends Camera{
	public void work() {
		System.out.println("�������Խ�������");
		System.out.println("��Ӱ�ɹ�");
	}
}
class DanFanCamera extends Camera{
	public void work() {
		System.out.println("�����������ţ������� ");
		System.out.println("��Ӱ�ɹ�");
	}
}
class MiniCamera extends Camera{
	public void work() {
		System.out.println("�����������ţ������� ");
		System.out.println("��Ӱ�ɹ�");
	}
}

abstract class Mobile  {
	public abstract  void work() ;
}
class MeituMobile extends  Mobile implements PhotoDevice{
	public void work() {
		System.out.println("����ͼapp����ʼ���� ");
		System.out.println("��Ӱ�ɹ�");
	}
}
class NormalMObile extends Mobile{
	@Override
	public void work() {
		
	}
	
}


 class RecordPen implements PhotoDevice{
	@Override
	public void work() {
		System.out.println("��ǰ͵͵�򿪣������ؿڣ�Ȼ������¼��");
	}
	
}