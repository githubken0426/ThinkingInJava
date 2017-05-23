package cn.callBack.asychronous;

import cn.callBack.DoFillJob;
import cn.callBack.SuperCalculator;

/**
 * �첽�ص�
 * @author Administrator
 * 2016-5-4 ����09:47:03
 *
 */
class Student implements DoFillJob{
	
	private String name;
	
	public Student(String name){
		this.name=name;
	}

	@Override
	public void fillBank(double a, double b, double result) {
		System.out.println(name+"���ûص�����,������:"+a+"+"+b+"="+result);
	}
	
	public void callBack(final double a,final double b){
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				new SuperCalculator().add(a,b,new Student(name));
			}
		}).start();
		System.out.println(name+"��������󣬾ͳ�ȥ���ˣ�");
	}
}
