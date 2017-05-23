package th.part_17_DeepInCollection.chapter_06Set;

import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * first()返回容器中第一个元素
 * last()返回容器中最末一个元素
 * subSet(from,to)生成从from(包含)到to(不包含)的set子集
 * headSet(to)生成小于to的set子集
 * tailSet(from)生成大于from(包含)的set子集
 * @author Administrator
 * 2016-4-26 上午11:51:28
 *
 */
public class SortedSetDemo {
	public static void main(String[] args) {
		//SortedSet
		SortedSet<String> set=new TreeSet<String>();
		Collections.addAll(set, "one two three four five six seven eight".split(" "));
		System.out.println(set);
		
		String low=set.first();
		System.out.println(low);
		
		String high=set.last();
		System.out.println(high);
		
		Iterator<String> it=set.iterator();
		for(int i=0;i<6;i++){
			if(i==3)
				low=it.next();
			if(i==6)
				high=it.next();
			else
				it.next();
		}
		System.out.println("low="+low);
		System.out.println("high="+high);
		
		System.out.println(set.subSet(low, high));
		System.out.println(set.headSet(high));
		System.out.println(set.tailSet(low));
	}
}
