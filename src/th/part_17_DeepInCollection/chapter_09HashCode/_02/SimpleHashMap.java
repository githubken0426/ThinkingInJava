package th.part_17_DeepInCollection.chapter_09HashCode._02;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import th.part_17_DeepInCollection.chapter_02Fill._03Abstract.Countries;
import th.part_17_DeepInCollection.chapter_09HashCode._01.MapEntry;

public class SimpleHashMap<K, V> extends AbstractMap<K, V> {
	static final int size=997;
	@SuppressWarnings("unchecked")
	LinkedList<MapEntry<K,V>> [] buckets=new LinkedList[size];
	
	@Override
	public V get(Object key) {
		int index=Math.abs(key.hashCode())%size;
		if(buckets[index]==null) return null;
		for(Map.Entry<K, V> en: buckets[index]){
			if(en.getKey().equals(key))
				return en.getValue();
		}
		return null;
	}

	@Override
	public V put(K key, V value) {
		V oldValue=null;
		int index=Math.abs(key.hashCode())%size;
		if(buckets[index]==null)
			buckets[index]=new LinkedList<MapEntry<K,V>>();
		LinkedList<MapEntry<K,V>> bucket=buckets[index];
		MapEntry<K,V> pair=new MapEntry<K,V>(key,value);
		boolean found=false;
		ListIterator<MapEntry<K,V>> it=bucket.listIterator();
		while(it.hasNext()){
			MapEntry<K,V> ele=it.next();
			if(ele.getKey().equals(key)){
				oldValue=ele.getValue();
				it.set(pair);
				found=true;
				break; 
			}
		}
		if(!found)
			buckets[index].add(pair);
		return oldValue;
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K,V>> set=new HashSet<Map.Entry<K,V>>();
		for(LinkedList<MapEntry<K,V>> bucket:buckets){
			if(bucket==null) continue;
			for(MapEntry<K,V> map:bucket){
				set.add(map);
			}
		}
		return set;
	}

	public static void main(String[] args) {
		SimpleHashMap<String,String> map=new SimpleHashMap<String,String>();
		map.putAll(Countries.capitals(3));
		System.out.println(map);
		System.out.println(map.get("Algeria"));
		
		System.out.println(map.entrySet());
	}
}
