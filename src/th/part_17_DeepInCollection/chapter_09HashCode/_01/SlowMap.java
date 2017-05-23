package th.part_17_DeepInCollection.chapter_09HashCode._01;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import th.part_17_DeepInCollection.chapter_02Fill._03Abstract.Countries;

/**
 * 17.9.1 理解hashCode()
 * 使用散列的目的在于：想要使用一个对象查找另一个对象
 * 不过TreeMap或者自己实现的Map也可以达到此目的。
 * @author ken
 * @param <K>
 * @param <V>
 * 2017-1-13 下午02:46:39
 */
public class SlowMap<K, V> extends AbstractMap<K, V> {
	public List<K> keys=new ArrayList<K>();
	public List<V> values=new ArrayList<V>();
	
	/**
	 * put返回已经存在key的value
	 * 如果key不存在返回null
	 */
	public V put(K key,V value){
		V oldValue=get(key);
		if(!keys.contains(key)){
			keys.add(key);
			values.add(value);
		}else{
			values.set(keys.indexOf(key), value);
		}
		return oldValue;	
	}
	
	@Override
	public V get(Object obj){
		if(!keys.contains(obj))
			return null;
		return values.get(keys.indexOf(obj));
	}
	
	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> set=new HashSet<Map.Entry<K,V>>();
		Iterator<K> itKey=keys.iterator();
		Iterator<V> itValue=values.iterator();
		while(itKey.hasNext()){
			set.add(new MapEntry<K,V>(itKey.next(),itValue.next()));
		}
		return set;
	}
	public static void main(String[] args) {
		SlowMap<String,String> map=new SlowMap<String,String>();
		map.putAll(Countries.capitals(3));
		System.out.println(map);
		System.out.println(map.get("Algeria"));
		System.out.println(map.entrySet());
	}

}
