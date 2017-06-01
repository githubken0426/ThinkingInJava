package th.part_16_Array._07_Arrays._05BinarySearch;

import java.util.Arrays;

import TIJ4_code.net.mindview.util.Generated;
import TIJ4_code.net.mindview.util.RandomGenerator;


public class AlphabeticSearch {
	public static void main(String[] args) {
		String a[]=Generated.array(new String[10], new RandomGenerator.String(5));
		System.out.println("before sort:"+Arrays.toString(a));
		Arrays.sort(a);
		System.out.println("after sort:"+Arrays.toString(a));
	
		/**
		 * 字符串排序先大写后小写
		 * String.CASE_INSENSITIVE_ORDER 忽略大小写
		 */
		Arrays.sort(a,String.CASE_INSENSITIVE_ORDER);
		System.out.println("case-insensitive sort:"+Arrays.toString(a));
		
		int index=Arrays.binarySearch(a,a[9],String.CASE_INSENSITIVE_ORDER);
		System.out.println("index:"+index+",a["+index+"]:"+a[index]);
	}
}
