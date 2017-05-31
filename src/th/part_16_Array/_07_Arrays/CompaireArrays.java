package th.part_16_Array._07_Arrays;

import java.util.Arrays;

/**
 * 比较数组
 * 
 * @author Administrator 
 * 2015-11-19 下午03:05:44
 * 
 */
public class CompaireArrays {
	public static void main(String[] args) {
		int[] i = new int[10];
		int[] j = new int[10];
		Arrays.fill(i, 47);
		Arrays.fill(j, 47);
		System.out.println("Arrays.equals(i, j):" + Arrays.equals(i, j));
		j[3] = 11;
		System.out.println("Arrays.equals(i, j):" + Arrays.equals(i, j));
		
		//数组相等是基于内容的，所以结果为true
		String[] s1 = new String[4];
		Arrays.fill(s1, "HI");
		String[] s2 = new String[] { new String("HI"), new String("HI"),
				new String("HI"), new String("HI") };
		System.out.println("Arrays.equals(str1, str2):"+ Arrays.equals(s1, s2));
	}
}
