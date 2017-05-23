package cn.callBack.synchronize;

import cn.callBack.DoFillJob;
import cn.callBack.SuperCalculator;

public class Seller implements DoFillJob {
	private String name;
	public Seller(String name){
		this.name=name;
	}
	
	@Override
	public void fillBank(double a, double b, double result) {
		System.out.println(name+"回调函数计算结果:"+a+"+"+b+"="+result);
	}
	
	public void callBack(double a, double b){
		System.out.println(name+"问完问题后，等待结果！");
		new SuperCalculator().add(a,b,this);
	}
}
