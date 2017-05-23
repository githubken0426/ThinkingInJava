package cn.callBack.part_4;

/**
 * º∆À„¿‡
 * @author Administrator
 *
 */
public class SuperCalculator {
	public static void calcADD(double a, double b,DoJob job) {
		job.fillBank(a, b,a+b);
	}
}
