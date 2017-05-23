package th.util;

import java.util.HashSet;
import java.util.Set;

public class CommonSets {
	/**
	 * 将两个参数合并
	 * @param a
	 * @param b
	 * @return
	 *	2015年9月25日
	 */
	public static <T> Set<T> union(Set<T> a,Set<T> b){
		Set<T> result=new HashSet<T>(a);
		result.addAll(b);
		return result;
	}
	/**
	 * 返回两个参数共有的部分
	 * @param a
	 * @param b
	 * @return
	 *	2015年9月25日
	 */
	public static <T> Set<T> interSelection(Set<T> a,Set<T> b){
		Set<T> result=new HashSet<T>(a);
		result.retainAll(b);
		return result;
	}
	/**
	 * 返回两个参数不相同部分
	 * @param superSet
	 * @param subSet
	 * @return
	 *	2015年9月25日
	 */
	public static <T> Set<T> dfference(Set<T> superSet,Set<T> subSet){
		Set<T> result=new HashSet<T>(superSet);
		result.removeAll(subSet);
		return result;
	}
	
	/**
	 * 返回两个参数交集之外的元素
	 * @param a
	 * @param b
	 * @return
	 *	2015年9月25日
	 */
	
	public static <T> Set<T> complement(Set<T> a,Set<T> b){
		return dfference(union(a,b),interSelection(a,b));
	}
}
