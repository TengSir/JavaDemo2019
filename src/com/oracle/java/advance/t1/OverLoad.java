package com.oracle.java.advance.t1;

/**
 * �������أ���һ�����У� ����ж������������ͬ�� ���ǲ����б�ͬ�������ĸ��������������ͣ�������˳����һ����ͬ�����ڲ����б�ͬ��
 * 
 *������Ϊ������ͬ��ɵĶԷ���������
 * @author tengsir
 *
 */
public class OverLoad {
	public void eatFood() {

	}

	public void eatRice(int a) {

	}

	private void eatIce(String a) {

	}

	public int eat(String a, int b) {
		return 0;
	}

	public void eat(int b, String a) {

	}
}

class Other {
	public void eat() {

	}
}
