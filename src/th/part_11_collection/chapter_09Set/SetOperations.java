package th.part_11_collection.chapter_09Set;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SetOperations {
	public static void main(String[] args) {
		Set<String> set1=new HashSet<String>();
		Collections.addAll(set1, "B D F G H O P".split(" "));
		set1.add("L");
		
		System.out.println("contains()L:"+set1.contains("L"));
		System.out.println("set1:"+set1);
		
		Set<String> set2=new HashSet<String>();
		Collections.addAll(set2, "B A Q W E R P".split(" "));
		
		System.out.println("containsAll():"+set1.containsAll(set2));
		System.out.println("set2:"+set2);
		Collections.addAll(set2, "V X Z".split(" "));
		System.out.println("addAll(set2,V X Z):"+set2);
	}
}
