package cn.callBack.asychronous;

import cn.callBack.DoFillJob;
import cn.callBack.SuperCalculator;

public class Seller implements DoFillJob {
	private String name;
	public Seller(String name){
		this.name=name;
	}
	
	@Override
	public void fillBank(double a, double b, double result) {
		System.out.println(name+"���ûص�����������:"+a+"+"+b+"="+result);
	}
	
	public void callBack(final double a,final double b){
		new Thread(new Runnable(){
			@Override
			public void run() {
				new SuperCalculator().add(a,b,new Seller(name));
			}
		}).start();
		System.out.println(name+"��������󣬾ͼ����������ˣ�");
	}
}
