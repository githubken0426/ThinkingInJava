package th.part_16_Array._07_Arrays;

import java.util.Arrays;


public class CopyingArrays {
	
	public static void main(String[] args) {
		int []i=new int[7];
		int []j=new int[10];
		Arrays.fill(i, 47);
		Arrays.fill(j, 99);
		System.out.println(Arrays.toString(i));
		System.out.println(Arrays.toString(j));
		System.arraycopy(i, 0, j, 3, i.length);
		System.out.println(Arrays.toString(j));
		/*
		 * for循环应用于boolean
		 * boolean b=true;
		for(result(b);result(1<1);result(true)){
		}*/
		
	}
	
	public static boolean result(boolean res){
		System.out.println(res);
		return res;
	}
}
