package th.part_14_TypeInfo.exercise._10;

public class E10_TestArray {

	public static void main(String[] args) {
		char [] ch={'a','b','c'};
		System.out.println(ch.getClass());
		
//		char cc='a';
//		System.out.println(cc.getClass());
		
		int [] it=new int[3];
		System.out.println(it.getClass());
		
		long [] lo=new long[3];
		System.out.println(lo.getClass());
		
		String [] str=new String[3];
		System.out.println(str.getClass());
		
		E10_TestArray[] e10=new E10_TestArray[2];
		System.out.println(e10.getClass());
	}

}
