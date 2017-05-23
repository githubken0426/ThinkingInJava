package cn.callBack.synchronize;

import cn.callBack.DoFillJob;
import cn.callBack.SuperCalculator;

/**
 * �ص�(CallBack)����
 * @author Administrator
 * 2016-5-4 ����08:55:57
 *
 */
 class Student implements DoFillJob{
	private String name;
	
	public Student(String name){
		this.name=name;
	}
	
	@Override
	public void fillBank(double a,double b,double result){
		System.out.println(name+"�ص�����������:"+a+"+"+b+"="+result);
	}
	
	public void callBack(double a,double b){
		System.out.println(name+"��������󣬵ȴ������");
		new SuperCalculator().add(a,b,this);
	}
	
}
