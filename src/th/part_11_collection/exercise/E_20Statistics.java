package th.part_11_collection.exercise;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class E_20Statistics {
	public static void main(String[] args) {
		Set<Character> set= new HashSet<Character>();
		Collections.addAll(set,'a','e','i','o','A','E','I','O','U');
		System.out.println(set);
		Map<Object,Integer> map=new HashMap<Object,Integer>();
		Iterator<Character> it=set.iterator();
		while(it.hasNext()){
			String obj=it.next().toString().toLowerCase();
			Integer val = map.get(obj);
			map.put(obj, val==null?1:val+1);
		}
		System.out.println(map);
	}
}
