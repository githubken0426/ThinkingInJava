package th.part_17_DeepInCollection.chapter_08Map.sortedMap;

import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

import th.part_17_DeepInCollection.chapter_02Fill._03Abstract.CountingMapData;
/**
 * 17.8.2
 * TreeMap是SortedMap现阶段的唯一实现
 * public abstract interface NavigableMap extends SortedMap 
 * public class TreeMap extends AbstractMap implements NavigableMap, Cloneable, Serializable
 * 
 * @author ken
 * 2017-1-12 下午04:23:54
 */
public class SortedMapDemo {
	public static void main(String[] args) {
		SortedMap<Integer,String> sortedMap=new TreeMap<Integer,String>(new CountingMapData(10));
		System.out.println(sortedMap);
		Integer low=sortedMap.firstKey();
		Integer height=sortedMap.lastKey();
		System.out.println("low="+low+",height="+height);
		Iterator<Integer> it=sortedMap.keySet().iterator();
		for(int i=0;i<=6;i++){
			if(i==3) low=it.next();
			if(i==6) height=it.next();
			else it.next();
		}
		System.out.println("after low="+low+",height="+height);
		//subMap(fromKey,toKey)返回子集(fromKey<=子集<toKey)
		System.out.println(sortedMap.subMap(low, height));
		//headMap(toKey)返回子集(子集<toKey)
		System.out.println(sortedMap.headMap(height));
		//tailMap(fromKey)返回子集(fromKey<=子集)
		System.out.println(sortedMap.tailMap(low));
	}
}
