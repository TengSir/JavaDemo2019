package com.oracle.java.advance.t2;
//��װ�ľ���ʵʩ���裺1����˽�л���2�ṩ��׼��get��set
public class Demo {
	public static void main(String[] args) {
		CreditCard  c=new CreditCard();
		System.out.println(c.getPassword());
	}

}

class CreditCard{
	private String password="123321";
	private String password1="123321";
	private String password2="123321";
	private String password3="123321";
	private String password4="123321";
	private String password5="123321";
	private String password6="123321";
//	public String getPassword() {
//		System.out.println("�������������");
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password=password;
//	}
	double money=100;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getPassword3() {
		return password3;
	}
	public void setPassword3(String password3) {
		this.password3 = password3;
	}
	public String getPassword4() {
		return password4;
	}
	public void setPassword4(String password4) {
		this.password4 = password4;
	}
	public String getPassword5() {
		return password5;
	}
	public void setPassword5(String password5) {
		this.password5 = password5;
	}
	public String getPassword6() {
		return password6;
	}
	public void setPassword6(String password6) {
		this.password6 = password6;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
}
