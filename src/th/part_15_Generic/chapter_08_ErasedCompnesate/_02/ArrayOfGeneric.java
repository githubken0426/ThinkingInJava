package th.part_15_Generic.chapter_08_ErasedCompnesate._02;

public class ArrayOfGeneric {
	final static int size=100;
	static Generic<Integer>[] gia;
	
	/**
	 * 数组在创建时将跟踪他们的实际类型，这个类型是在创建数组时确定的
	 * @param args
	 * 2016-10-24 上午09:09:25
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
