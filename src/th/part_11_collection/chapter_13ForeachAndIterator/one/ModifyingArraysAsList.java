package th.part_11_collection.chapter_13ForeachAndIterator.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


/**
 * ���Կ���Collections.shuffle()��������
 * @author Administrator
 * 2016-4-19 ����03:17:36
 *
 */
public class ModifyingArraysAsList {
	public static void main(String[] args) {
		Random random =new Random(47);
		Integer [] data={2,1,4,8,6,9,20};
		/**
		 * ʹ��ArrayList����������Arrays.asList()����ᴴ�����������
		 * ����shuffle()������������ҵײ�����
		 */
		List<Integer> list= new ArrayList<Integer>(Arrays.asList(data));
		System.out.println("Before shuffling:"+list);
		Collections.shuffle(list,random);
		System.out.println("After shuffling:"+list);
		System.out.println("Array:"+Arrays.toString(data));
		
		/**
		 * ֱ��ʹ��Arrays.asList()������List����
		 * ��ʹ�õײ�������Ϊ����ʵ��
		 */
		List<Integer> list2=Arrays.asList(data);
		System.out.println("Before shuffling 2:"+list2);
		Collections.shuffle(list2,random);
		System.out.println("After shuffling 2:"+list2);
		System.out.println("Array 2:"+Arrays.toString(data));
	}
}
