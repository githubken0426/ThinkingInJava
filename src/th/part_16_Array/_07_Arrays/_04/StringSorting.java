package th.part_16_Array._07_Arrays._04;

import java.util.Arrays;
import java.util.Collections;

import TIJ4_code.net.mindview.util.Generated;
import TIJ4_code.net.mindview.util.RandomGenerator;

/**
 * 数组排序
 * 
 * 基本类型的数组可以直接排序，
 * String也是实现了Comparable接口，可以直接排序。
 * 引用类型的数组不能直接排序,必须实现Comparable接口
 * 
 * @author ken
 * 2017-5-31 下午02:29:09
 */
public class StringSorting {
	public static void main(String[] args) {
		String a[]=Generated.array(new String[20], new RandomGenerator.String(5));
		System.out.println("before sort:"+Arrays.toString(a));
		Arrays.sort(a);
		System.out.println("after sort:"+Arrays.toString(a));
		
		Arrays.sort(a,Collections.reverseOrder());
		System.out.println("Reverse sort:"+Arrays.toString(a));
		/**
		 * 字符串排序先大写后小写
		 * String.CASE_INSENSITIVE_ORDER 忽略大小写
		 */
		Arrays.sort(a,String.CASE_INSENSITIVE_ORDER);
		System.out.println("case-insensitive sort:"+Arrays.toString(a));
	}
}
