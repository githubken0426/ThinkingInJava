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
		 * Collection的构造器可以接收另一个Collection来初始化自身,
		 * Collections.addAll()方法会快很多，这是首选方式
		 */
		Collection<Integer> collection=new ArrayList<Integer>(Arrays.asList(11,21,13,56,3));
		/**
		 * 这块类似StringBuilder追加
		 */
		Collections.addAll(collection, 1,2,7);
		System.out.println("After Collections.addAll():"+collection.toString());
		/**
		 * Collection对象的addAll()成员方法只能接收另一个Collection对象
		 * 
		 */
		collection.addAll(Arrays.asList(5,8,9));
		System.out.println("After collection.addAll():"+collection.toString());
		
		//sort必须实现Comparable接口
		Collection<Crusty> collection2=new ArrayList<Crusty>(Arrays.asList( new Crusty()));
		Collections.sort( (List<Crusty>) collection2);
		System.out.println(collection2.toString());
		
		Integer a[]=new Integer[]{10,11,12,13,14,15};
		List<Integer> list=Arrays.asList(a);
		list.set(0, 100);
		/**
		 * 添加异常：java.lang.UnsupportedOperationException
		 * Arrays.asList()其底层还是数组，所有无法改变list大小
		 */
//		list.add(20);
		System.out.println(list.toString());
	}
}
