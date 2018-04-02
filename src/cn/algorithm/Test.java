package cn.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.sun.tools.javac.code.Attribute.Array;

/**
 * 随机因子:
 * 种子数只是随机算法的起源数字，和生成的随机数字的区间无关。
 * @author ken
 *
 */
public class Test {
	private static List<Integer> array=new ArrayList<Integer>();
	static{
		for(int i=20;i>0;i--){
			Random random=new Random(i);
			int result=random.nextInt(i);
			if(!array.contains(result))
				array.add(result);
		}
	}
	
	public static void main(String[] args) {
		Integer a[]=new Integer[array.size()];
		Integer result[]=array.toArray(a);
		System.out.println("排序前");
		testSort(result);
		System.out.println();
		System.out.println("排序后");
		//testSort(ExchangeSort.Bubble.bubbleSort_2(result));
		ExchangeSort.QuickSort.quickSort2(result,0,result.length-1);
		testSort(result);
	}
	
	public static void testSort(Integer[] array){
		for (int item : array) {
			System.out.print(item);
			System.out.print(",");
		}
	}
}
