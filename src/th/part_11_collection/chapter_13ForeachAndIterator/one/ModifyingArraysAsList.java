package th.part_11_collection.chapter_13ForeachAndIterator.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


/**
 * 可以看出Collections.shuffle()打乱排序
 * @author Administrator
 * 2016-4-19 下午03:17:36
 *
 */
public class ModifyingArraysAsList {
	public static void main(String[] args) {
		Random random =new Random(47);
		Integer [] data={2,1,4,8,6,9,20};
		/**
		 * 使用ArrayList构造器传入Arrays.asList()对象会创建数组的引用
		 * 调用shuffle()方法并不会打乱底层数组
		 */
		List<Integer> list= new ArrayList<Integer>(Arrays.asList(data));
		System.out.println("Before shuffling:"+list);
		Collections.shuffle(list,random);
		System.out.println("After shuffling:"+list);
		System.out.println("Array:"+Arrays.toString(data));
		
		/**
		 * 直接使用Arrays.asList()产生的List对象
		 * 会使用底层数组作为物理实现
		 */
		List<Integer> list2=Arrays.asList(data);
		System.out.println("Before shuffling 2:"+list2);
		Collections.shuffle(list2,random);
		System.out.println("After shuffling 2:"+list2);
		System.out.println("Array 2:"+Arrays.toString(data));
	}
}
