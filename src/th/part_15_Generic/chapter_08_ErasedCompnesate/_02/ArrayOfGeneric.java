package th.part_15_Generic.chapter_08_ErasedCompnesate._02;

public class ArrayOfGeneric {
	final static int size=100;
	static Generic<Integer>[] gia;
	
	/**
	 * �����ڴ���ʱ���������ǵ�ʵ�����ͣ�����������ڴ�������ʱȷ����
	 * @param args
	 * 2016-10-24 ����09:09:25
	 */
	public static void main(String[] args) {
//		gia=(Generic<Integer>[])new Object[size];
		gia=new Generic[size];
		System.out.println(gia.getClass().getSimpleName());
		gia[0]=new Generic<Integer>();
		
//		gia[1]=(Generic<Integer>) new Object();
//		gia[2]=new Generic<Float>();
	}
}
