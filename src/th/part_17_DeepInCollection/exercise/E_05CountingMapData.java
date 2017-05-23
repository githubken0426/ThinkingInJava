package th.part_17_DeepInCollection.exercise;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class E_05CountingMapData extends AbstractMap<Integer,String>{
	private int size;
	static String[] chars="A B E T U I O P".split(" ");
	
	public E_05CountingMapData(int size){
		this.size=size<0?0:size;
	}
	
	private  class Entry implements Map.Entry<Integer,String>{
		
		int index;
		
		Entry(int index){
			this.index=index;
		}
		
		public boolean equals(Object o){
			return Integer.valueOf(index).equals(o);
		}
		
		public int hashCode(){
			return Integer.valueOf(index).hashCode();
		}
		
		@Override
		public Integer getKey() {
			return index;
		}

		@Override
		public String getValue() {
			return chars[index%chars.length]+ Integer.toString(index/chars.length);
		}

		@Override
		public String setValue(String value) {
			throw new UnsupportedOperationException();
		}
	}

	 class EntrySet extends AbstractSet<Map.Entry<Integer,String>>{
		 class Iter implements Iterator<java.util.Map.Entry<Integer, String>>{
			 private Entry entry=new Entry(-1);
			@Override
			public boolean hasNext() {
				return entry.index<size-1;
			}

			@Override
			public java.util.Map.Entry<Integer, String> next() {
				entry.index++;
				return entry;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		 }
		 
		@Override
		public Iterator<java.util.Map.Entry<Integer, String>> iterator() {
			return new Iter();
		}

		@Override
		public int size() {
			return size;
		}
		
	}
	 Set<Map.Entry<Integer, String>> entries=new EntrySet();
	@Override
	public Set<Map.Entry<Integer, String>> entrySet() {
		return entries;
	}
	
	public static void main(String[] args) {
		System.out.println(new E_05CountingMapData(10));;
	}
}
