package th.part_11_collection.chapter_03;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AddingGroups {
	public static void main(String[] args) {
		/**
		 * Collection�Ĺ��������Խ�����һ��Collection����ʼ������,
		 * Collections.addAll()�������ܶ࣬������ѡ��ʽ
		 */
		Collection<Integer> collection=new ArrayList<Integer>(Arrays.asList(11,21,13,56,3));
		/**
		 * �������StringBuilder׷��
		 */
		Collections.addAll(collection, 1,2,7);
		System.out.println("After Collections.addAll():"+collection.toString());
		/**
		 * Collection�����addAll()��Ա����ֻ�ܽ�����һ��Collection����
		 * 
		 */
		collection.addAll(Arrays.asList(5,8,9));
		System.out.println("After collection.addAll():"+collection.toString());
		
		//sort����ʵ��Comparable�ӿ�
		Collection<Crusty> collection2=new ArrayList<Crusty>(Arrays.asList( new Crusty()));
		Collections.sort( (List<Crusty>) collection2);
		System.out.println(collection2.toString());
		
		Integer a[]=new Integer[]{10,11,12,13,14,15};
		List<Integer> list=Arrays.asList(a);
		list.set(0, 100);
		/**
		 * ����쳣��java.lang.UnsupportedOperationException
		 * Arrays.asList()��ײ㻹�����飬�����޷��ı�list��С
		 */
//		list.add(20);
		System.out.println(list.toString());
	}
}
