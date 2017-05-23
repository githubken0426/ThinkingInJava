package th.part_17_DeepInCollection.chapter_02Fill._02MapGenerator;

import java.util.LinkedHashMap;

import TIJ4_code.net.mindview.util.Generator;

public class MapData<K, V> extends LinkedHashMap<K, V> {
	private static final long serialVersionUID = 1L;

	public MapData(Generator<Pair<K,V>> gen,int quantity){
		for(int i=0;i<quantity;i++){
			Pair<K,V> p=gen.next();
			put(p.key,p.value);
		}
	}
	
	public MapData(Generator<K> k,Generator<V> v,int quantity){
		for(int i=0;i<quantity;i++){
			put(k.next(),v.next());
		}
	}
	
	public MapData(Generator<K> k,V v,int quantity){
		for(int i=0;i<quantity;i++){
			put(k.next(),v);
		}
	}
	
	public MapData(Iterable<K> k,V v){
		for(K key:k){
			put(key,v);
		}
	}
	
	public static <K,V> MapData<K,V> map(Generator<Pair<K,V>> gen,int quantity){
		return new MapData<K,V>(gen,quantity);
	}
	
	public static <K,V> MapData<K,V> map(Generator<K> k,Generator<V>v,int quantity){
		return new MapData<K,V>(k,v,quantity);
	}
	
	public static <K,V> MapData<K,V> map(Generator<K> k,V v,int quantity){
		return new MapData<K,V>(k,v,quantity);
	}
	
	public static <K,V> MapData<K,V> map(Iterable<K> k,V v){
		return new MapData<K,V>(k,v);
	}
}
