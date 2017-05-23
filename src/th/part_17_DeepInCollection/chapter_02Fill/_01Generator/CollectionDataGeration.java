package th.part_17_DeepInCollection.chapter_02Fill._01Generator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import TIJ4_code.net.mindview.util.RandomGenerator;

public class CollectionDataGeration {
	public static void main(String[] args) {
		List<String> list1= new ArrayList<String>(CollectionData.list(new RandomGenerator.String(9), 5));
		System.out.println("ArrayList:"+list1);
		Set<Integer> set= new HashSet<Integer>(CollectionData.list(new RandomGenerator.Integer(19), 5));
		System.out.println("HashSet:"+set);
	}
}
