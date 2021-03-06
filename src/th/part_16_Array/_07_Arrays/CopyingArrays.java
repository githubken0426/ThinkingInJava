package th.part_16_Array._07_Arrays;

import java.util.Arrays;

/**
 * 复制数组
 * 
 * @author ken
 * 2017-5-31 下午02:29:28
 */
public class CopyingArrays {
	
	public static void main(String[] args) {
		int []i=new int[]{1,2,3,4,5,6,7};
		int []j=new int[10];
//		Arrays.fill(i, 47);
		Arrays.fill(j, 99);
		System.out.println("i="+Arrays.toString(i));
		System.out.println("j="+Arrays.toString(j));
		/**
		 * shallow copy 
		 * 潜复制，如果复制非基本类型数组(即对象数组)
		 * 		   只是复制了引用--而不是对象本身的copy
		 * 
		 * java.lang.System.arraycopy(Object src, int srcPos, 
		 * 							  Object dest,int destPos, int length)
		 * src:源数组
		 * srcPos:从源数组什么位置开始复制的偏移量
		 * dest:目标数组
		 * destPos:从目标数组什么位置开始复制的偏移量
		 * length:需要复制的元素个数
		 */
		System.arraycopy(i, 0, j, j.length-i.length, i.length);
		System.out.println("j="+Arrays.toString(j));
		/*
		 * for循环应用于boolean
		 * boolean b=true;
		   for(result(b);result(1<1);result(true)){
		   }
		*/
		
	}
	
	public static boolean result(boolean res){
		System.out.println(res);
		return res;
	}
}
