package th.part_15_Generic.chapter_04_GenericMethod._06;

import java.util.HashSet;
import java.util.Set;

public class Sets {
	public static <T> Set<T> union(Set<T> a, Set<T> b){
		Set<T> result=new HashSet<T>(a);
		result.addAll(b);
		return result;
	}
	
	public static <T> Set<T> interSection(Set<T> a, Set<T> b){
		Set<T> result=new HashSet<T>(a);
		result.retainAll(b);
		return result;
	}
	
	public static <T> Set<T> difference(Set<T> a, Set<T> b){
		Set<T> result=new HashSet<T>(a);
		result.removeAll(b);
		return result;
	}
	
	public static <T> Set<T> conplement(Set<T> a, Set<T> b){
		return difference(union(a,b),interSection(a,b));
	}
}
