package cn.callBack;

import java.util.concurrent.TimeUnit;


public class SuperCalculator {
	/**
	 * �˴������˺����Ļص�
	 * @param a
	 * @param b
	 * @param stu
	 */
	public void add(double a,double b,DoFillJob fill){
		try {
			System.out.println("�����������ʱ10�룡");
			TimeUnit.SECONDS.sleep(10);
			fill.fillBank(a, b, a+b);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
