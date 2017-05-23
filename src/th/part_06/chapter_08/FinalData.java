package th.part_06.chapter_08;

public class FinalData {
	final int dt1=1;
	static final int DT2=2;
	public static final int dt3=3;
	
	Value v1=new Value();
	
	final Value v2=new Value();
	
	static final Value v3=new Value();
	/**
	 * static�ĳ���������ص�ʱ�򱻳�ʼ����
	 * ��ʵ��������ʵ������ʱ�򱻳�ʼ��
	 * ��̬�Ķ���ֻ�ᱻ��ʼ��һ�Σ�����������ص�ʱ��
	 * @param args
	 */
	public static void main(String[] args) {
		FinalData fd1 = new FinalData();
		//fd1.dt1++; // Error: can't change value
		System.out.println(++fd1.v2.i);
		// Object isn't constant!
		fd1.v1 = new Value(); // OK -- not final
		
		//fd1.v2 = new Value(); // Error: Can't
		//fd1.v3 = new Value(); // change handle
	}
}
