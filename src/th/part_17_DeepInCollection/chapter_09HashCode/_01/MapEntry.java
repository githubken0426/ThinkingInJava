package th.part_17_DeepInCollection.chapter_09HashCode._01;

import java.util.Map;

public class MapEntry<K, V> implements Map.Entry<K, V> {
	private K key;
	private V value;

	public MapEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public K getKey() {
		return key;
	}

	@Override
	public V getValue() {
		return value;
	}

	@Override
	public V setValue(V arg0) {
		V result = value;
		value = arg0;
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof MapEntry))
			return false;
		MapEntry me = (MapEntry) o;
		return (key == null ? me.getKey() == null : key.equals(me.getKey()))
				&& (value == null ? me.getValue() == null : key.equals(me.getValue()));
	}

	/**
	 * ^��λ���
	 */
	@Override
	public int hashCode() {
		return (key == null ? 0 : key.hashCode())
				^ (value == null ? 0 : value.hashCode());
	}
	
	public String toString(){
		return key+"="+value;
	}
}
