package th.part_11_collection.chapter_05List;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class MapsAndSets {
	public static void main(String[] args) {
		/**
		 * TreeMap、HashMap会按照key值升序排序
		 * 注意：key值要相互兼容。
		 * 这块和HashSet有区别。
		 */
		
		Map<Object,Integer> map=new HashMap<Object,Integer>();
		map.put(1, 1);
		map.put(4, 4);
		map.put(2, 2);
		map.put(3, 3);
		System.out.println("HashMap:"+map);
		Iterator<Object> it=map.keySet().iterator();
		while(it.hasNext()){
			System.out.println("it.next():"+it.next());
		}
		Map<Object,Integer> treeMap=new TreeMap<Object,Integer>();
		treeMap.put("s", 4);
		treeMap.put("b", 2);
		treeMap.put("g", 3);
		treeMap.put("a", 1);
		treeMap.put("z", 5);
		System.out.println("TreeMap:"+treeMap);
		
		/**
		 * LinkedHashMap会按照插入顺序排序
		 */
		Map<Object,Integer> linkedHashMap=new LinkedHashMap<Object,Integer>();
		linkedHashMap.put(1,1);
		linkedHashMap.put(3,1);
		linkedHashMap.put(2,1);
		System.out.println("LinkedHashMap:"+linkedHashMap);
		
		/**
		 * HashSet无序不重复对象,使用的是散列
		 */
		Set<Object> set=new HashSet<Object>();
		set.add("gg");
		set.add("z");
		set.add("bok");
		set.add("aok");
		System.out.println("Set:"+set);
		
		/**
		 * TreeSet按照升序排序，使用的红黑树
		 */
		Set<Object> treeSet=new TreeSet<Object>();
		treeSet.add("z");
		treeSet.add("bok");
		treeSet.add("aok");
		treeSet.add("gg");
		System.out.println("TreeSet:"+treeSet);
		
		/**
		 * LinkedHashSet:按照插入的顺序排序
		 */
		Set<Object> linkedHashSet=new LinkedHashSet<Object>();
		linkedHashSet.add("d");
		linkedHashSet.add("a");
		linkedHashSet.add("n");
		linkedHashSet.add("b");
		System.out.println("LinkedHashSet:"+linkedHashSet);
	}
}
