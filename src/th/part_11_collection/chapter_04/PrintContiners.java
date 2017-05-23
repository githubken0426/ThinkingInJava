package th.part_11_collection.chapter_04;

import java.util.*;
/**
 * 11.4
 * 容器的打印
 * 
 * @author ken
 * 2016-12-23 上午09:41:45
 */
public class PrintContiners {
	static Collection<String> fill(Collection<String> collection){
		collection.add("First");
		collection.add("Second");
		collection.add("Third");
		return collection;
	}
	static Map<Object, String> fill(Map<Object,String> map){
		map.put("First", "Fuzzy");
		map.put("Second","Rags");
		map.put("Third", "Bosco");
		map.put("Third", "Spot");
		return map;
	}
	public static void main(String[] args) {
		System.out.println("ArrayList:"+fill(new ArrayList<String>()));
		System.out.println("LinkedList:"+fill(new LinkedList<String>()));
		System.out.println("HashSet:"+fill(new HashSet<String>()));
		System.out.println("TreeSet:"+fill(new TreeSet<String>()));
		System.out.println("LinkedHashSet:"+fill(new LinkedHashSet<String>()));
		System.out.println();
		//HashMap取得数据的顺序是完全随机的
		System.out.println("HashMap:"+fill(new HashMap<Object,String>()));
		//TreeMap实现SortMap接口，能够把它保存的记录根据键排序,默认是按键值的升序排序
		System.out.println("TreeMap:"+fill(new TreeMap<Object,String>()));
		//LinkedHashMap保存了记录的插入顺序
		System.out.println("LinkedHashMap:"+fill(new LinkedHashMap<Object,String>()));
	}
}
