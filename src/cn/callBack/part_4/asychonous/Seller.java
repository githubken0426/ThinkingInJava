package cn.callBack.part_4.asychonous;

import java.util.concurrent.TimeUnit;

import cn.callBack.part_4.DoJob;
import cn.callBack.part_4.SuperCalculator;

public class Seller implements DoJob {
	private String name;
	public Seller(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void fillBank(double a, double b, double result) {
		System.out.println(name + "����С�����:" + a + " + " + b + " = " + result);
	}
	/**
	 * ʵ���첽����
	 * @param a
	 * @param b
	 */
	public  void callHelp(final double a,final double b) {
		new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					System.out.println("Ϊ"+name+"������..........");
					TimeUnit.SECONDS.sleep(10);
					System.out.println("Ϊ"+name+"����10��֮��...");
					SuperCalculator.calcADD(a, b, new Seller(name));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		System.out.println(name+"��������󣬼�����������");
	}
}
