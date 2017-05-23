package th.part_17_DeepInCollection.chapter_06Set;

import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * first()���������е�һ��Ԫ��
 * last()������������ĩһ��Ԫ��
 * subSet(from,to)���ɴ�from(����)��to(������)��set�Ӽ�
 * headSet(to)����С��to��set�Ӽ�
 * tailSet(from)���ɴ���from(����)��set�Ӽ�
 * @author Administrator
 * 2016-4-26 ����11:51:28
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
