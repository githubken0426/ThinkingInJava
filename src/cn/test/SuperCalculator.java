package cn.test;

import java.util.concurrent.TimeUnit;

public class SuperCalculator {
	public static void getResult(double a,double b,DoFillJob job){
		try {
			System.out.println("正在计算中.....");
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		job.doFill(a, b, a+b);
	}
}
