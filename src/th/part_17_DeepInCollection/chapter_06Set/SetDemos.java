package th.part_17_DeepInCollection.chapter_06Set;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class SetDemos {
	
	static class SetType {
		int i;
		public SetType(int i){
			this.i=i;
		}
		
		public boolean equals(Object o){
			return o instanceof SetType && i==((SetType)o).i;
		}
		
		public String toString(){
			return Integer.toString(i);
		}
	}
	
	static class HashType extends SetType {
		public HashType(int i) {
			super(i);
		}
		
		public int hashCode(){
			return i;
		}
	}
	
	static class TreeType extends SetType implements Comparable<TreeType>{
		public TreeType(int i) {
			super(i);
		}

		@Override
		public int compareTo(TreeType o) {
			return o.i<i ? -1: (o.i== i ? 0 : 1);
		}
	}
	
	
	public static <T> Set<T> fill(Set<T> set,Class<T> type) {
		try {
			for(int i=0;i<10;i++){
				Constructor<T> c=type.getConstructor(int.class);
				T t=c.newInstance(i);
				set.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return set;
	}
	
	public static <T> void  test(Set<T> set,Class<T> type){
		fill(set,type);
		//≥¢ ‘ÃÌº”÷ÿ∏¥‘™Àÿ
		fill(set,type);
		
		System.out.println(set);
	}
	
	public static void main(String[] args) {
		try {
			Constructor<String> c=String.class.getConstructor(String.class);
			System.out.println(c.newInstance("1000"));
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
