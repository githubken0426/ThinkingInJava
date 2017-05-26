package th.part_16_Array._04_multidimensional;

import java.util.Arrays;

/**
 * 三维数组
 * @author Administrator
 * 2015年11月2日
 */
public class ThreeDWith {
	public static void main(String[] args) {
		int [][][]a=new int[3][2][3];
		//deepToString()可以将多维数组转换为多个String输出
		System.out.println(Arrays.deepToString(a));
		System.out.println(Arrays.toString(a));
	}
}
