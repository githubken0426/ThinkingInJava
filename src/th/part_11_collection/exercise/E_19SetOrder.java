package th.part_11_collection.exercise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class E_19SetOrder {
	public static void main(String[] args) {
		Set<Object> set=new HashSet<Object>();
		set.add("GHJO");
		set.add("GHIP");
		set.add("GHIO");
		set.add("ABC");
		set.add("ABD");
		System.out.println(set);
		String [] data=set.toArray(new String[0]);
		Arrays.sort(data);
		Set<Object> linkedSet=new LinkedHashSet<Object>();
		for (String str : data) 
		{
			linkedSet.add(str);
		}
		System.out.println(linkedSet);
	}
}
