package th.part_17_DeepInCollection.chapter_02Fill._03Abstract;

import java.util.AbstractMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class CountingMapData extends AbstractMap<Integer, String> {
	private int size;
	static String[] chars = "A B E T U I O P H V".split(" ");

	public CountingMapData(int size) {
		this.size = size < 0 ? 0 : size;
	}

	private static class Entry implements Map.Entry<Integer, String> {

		int index;

		Entry(int index) {
			this.index = index;
		}

		public boolean equals(Object o) {
			return Integer.valueOf(index).equals(o);
		}

		public int hashCode() {
			return Integer.valueOf(index).hashCode();
		}

		@Override
		public Integer getKey() {
			return index;
		}

		@Override
		public String getValue() {
			return chars[index % chars.length]
					+ Integer.toString(index / chars.length);
		}

		@Override
		public String setValue(String value) {
			throw new UnsupportedOperationException();
		}
	}

	@Override
	public Set<Map.Entry<Integer, String>> entrySet() {
		Set<Map.Entry<Integer, String>> entries = new LinkedHashSet<Map.Entry<Integer, String>>();
		for (int i = 0; i < size; i++)
			entries.add(new Entry(i));
		return entries;
	}

	public static void main(String[] args) {
		System.out.println(new CountingMapData(10));
	}
}
