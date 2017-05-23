package th.part_17_DeepInCollection.chapter_08Map;

import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

import th.part_17_DeepInCollection.chapter_02Fill._03Abstract.CountingMapData;



public class Maps {
	public static void printKeys(Map<Integer,String> map) {
		System.out.println("size:"+map.size()+"keys:"+map.keySet());
	}
	
	public static void test(Map<Integer,String> map){ 
		System.out.println("map.getClass().getSimpleName():"+map.getClass().getSimpleName());
		map.putAll(new CountingMapData(10));
		map.putAll(new CountingMapData(10));
		System.out.println(map);
		System.out.println("map.values():"+map.values());
		System.out.println("map.containsKey(9):"+map.containsKey(9));
		System.out.println("map.get(9):"+map.get(9));
		//遍历key
		Iterator<Integer> it=map.keySet().iterator();
		Integer key=it.next();
		System.out.println("first key:"+key);
		map.remove(key);
		//遍历value
		Iterator<String> str=map.values().iterator();
		System.out.println("value.next()"+str.next());
		
		System.out.println("after remove:"+map);
		map.clear();
		System.out.println("after map clear:map.isEmpty()="+map.isEmpty());
		
		map.putAll(new CountingMapData(10));
		
		//operation on the set, change the map
		Set<Integer> keySet= map.keySet();//当是treeMap时,treemap必须有自己的comparator实现
		map.keySet().remove(keySet);
		System.out.println("map.isEmpty():"+map.isEmpty());
		
	}
	public static void main(String[] args) {
//		test(new HashMap<Integer,String>());
		/**
		 * java.lang.ClassCastException:
		 * java.util.TreeMap$KeySet cannot be cast to java.lang.Comparable
		 */
//		test(new TreeMap<Integer,String>());
//		test(new TreeMap<Integer,String>(new Comparator<Object>(){
//			@Override
//			public int compare(Object arg0, Object arg1) {
//				return 0;
//			}}));
//		test(new LinkedHashMap<Integer,String>());
//		test(new IdentityHashMap<Integer,String>());
		test(new WeakHashMap<Integer,String>());
		test(new ConcurrentHashMap<Integer,String>());
	}
}
