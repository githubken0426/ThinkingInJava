package th.part_21_Concurrence.chapter_03._02Synchronized._03Atomic;

public class SerialNumberGenerator {
	/**
	 * �ɱ��ԣ�������������nextSerialNumber()������û��ͬ��������¶Թ����ɱ��ֵ����
	 * nextSerialNumber()������Ҫ����synchronized
	 */
	private static volatile int serialNumber=0;
	public static  int nextSerialNumber(){
		return serialNumber++;
	}
}
