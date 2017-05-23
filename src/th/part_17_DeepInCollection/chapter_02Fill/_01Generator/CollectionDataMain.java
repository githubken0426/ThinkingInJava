package th.part_17_DeepInCollection.chapter_02Fill._01Generator;

import java.util.HashSet;
import java.util.Set;

public class CollectionDataMain {
	public static void main(String[] args) {
		Set<String> set=new HashSet<String>(new CollectionData<String>(new Government(),5));
		System.out.println(set);
//		set.clear();
		set.addAll(CollectionData.list(new Government(),2));
		System.out.println(set);
	}	
}
