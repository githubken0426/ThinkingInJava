package cn.callBack.part_4;

/**
 * ������
 * @author Administrator
 *
 */
public class SuperCalculator {
	public static void calcADD(double a, double b,DoJob job) {
		job.fillBank(a, b,a+b);
	}
}
