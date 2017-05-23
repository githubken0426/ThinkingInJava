package th.part_11_collection.chapter_09Set;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class SetOfInteger {
	public static void main(String[] args) {
		Random random=new Random(47);
		/**
		 * HashSet出于速度的考虑，使用散列，无序输出
		 * TreeSet有序输出
		 */
		Set<Integer> hashSet=new HashSet<Integer>();
		Set<Integer> treeSet=new TreeSet<Integer>();
		for(int i=0;i<10000000;i++){
			treeSet.add(random.nextInt(30));
			hashSet.add(random.nextInt(30));
		}
		System.out.println("treeSet"+treeSet);
		System.out.println("hashSet"+hashSet);
	}
}
