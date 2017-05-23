package th.part_17_DeepInCollection.chapter_02Fill._03Abstract;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Countries {
	public static final String [][] DATA ={{"China","beijing"},{"Algeria","algeria"},{"Angola","angola"}};
	
	private static class FlyweightMap extends AbstractMap<String,String>{
		/**
		 * 实现Entry
		 * @author Administrator
		 * 2016-4-20 下午02:43:49
		 *
		 */
		private static class Entry implements Map.Entry<String, String>{
			int index;
			Entry(int index){
				this.index=index;
			}
			
			public boolean equals(Object obj){
				return DATA[index][0].equals(obj);
			}
			
			public int hashCode(){
				return DATA[index][0].hashCode();
			}
			
			@Override
			public String getKey() {
				return DATA[index][0];
			}

			@Override
			public String getValue() {
				return DATA[index][1];
			}

			@Override
			public String setValue(String value) {
				throw new UnsupportedOperationException();
			}
			
		}
		
		/**
		 * 继承AbstractSet
		 * @author Administrator
		 * 2016-4-20 下午02:44:08
		 *
		 */
		public static class EntrySet extends AbstractSet<Map.Entry<String,String>>{
			private  int size;
			EntrySet(int size){
				if(size<0)
					this.size=0;
				else if(size > DATA.length)
					this.size=DATA.length;
				else
					this.size=size;
			}
			
			@Override
			public int size(){
				return size;
			}
			
			public class MyIterator implements Iterator<Map.Entry<String, String>>{
				private Entry entry=new Entry(-1);
				
				@Override
				public boolean hasNext() {
//					System.out.println("hasNext");
					return entry.index <size -1;
				}

				@Override
				public java.util.Map.Entry<String, String> next() {
//					System.out.println("next");
					entry.index++;
					return entry;
				}

				@Override
				public void remove() {
					throw new UnsupportedOperationException();
				}
			}
			
			@Override
			public Iterator<java.util.Map.Entry<String, String>> iterator() {
				return new MyIterator();
			}
		}
		
		private static Set<Map.Entry<String, String>> entries=new EntrySet(DATA.length);
		
		@Override
		public Set<java.util.Map.Entry<String, String>> entrySet() {
			return entries;
		}
	}
	
	public static Map<String,String> select(final int size){
		return new FlyweightMap(){
			public Set<Map.Entry<String, String>> entrySet() {
				return new EntrySet(size);
			}
		};
	}
	
	static Map<String,String> map=new FlyweightMap();
	
	public static Map<String,String> capitals(){
		return map;
	}
	
	public static Map<String,String> capitals(int size){
		return select(size);
	}
	
	static List<String> names=new ArrayList<String>(map.keySet());
	public static List<String> names(){
		return names;
	}
	
	public static List<String> names(int size){
		return new ArrayList<String>(select(size).keySet());
	}
	
	public static void main(String[] args) {
//		System.out.println(capitals(10));
//		System.out.println(names(10));
		/**
		 * 初始化静态ArrayList对象变量names
		 * names调用FlyweightMap父类Map的keySet方法
		 * Map调用FlyweightMap重写的Iterator接口方法
		 */
//		new Countries();
	}
}
