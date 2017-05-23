package th.part_17_DeepInCollection.exercise;

import java.util.TreeSet;

import TIJ4_code.net.mindview.util.CollectionData;
import TIJ4_code.net.mindview.util.RandomGenerator;

public class E_09 {
	public static void main(String[] args) {
		TreeSet<String> set=new TreeSet<String>();
		set.addAll(CollectionData.list(new RandomGenerator.String(),10));
		System.out.println(set);
	}
}
