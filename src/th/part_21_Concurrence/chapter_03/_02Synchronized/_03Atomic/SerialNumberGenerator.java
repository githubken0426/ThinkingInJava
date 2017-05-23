package th.part_21_Concurrence.chapter_03._02Synchronized._03Atomic;

public class SerialNumberGenerator {
	/**
	 * 可变性，真正的问题是nextSerialNumber()方法在没有同步的情况下对共享、可变的值访问
	 * nextSerialNumber()方法需要加上synchronized
	 */
	private static volatile int serialNumber=0;
	public static  int nextSerialNumber(){
		return serialNumber++;
	}
}
