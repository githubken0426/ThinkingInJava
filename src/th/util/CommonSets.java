package th.util;

import java.util.HashSet;
import java.util.Set;

public class CommonSets {
	/**
	 * �����������ϲ�
	 * @param a
	 * @param b
	 * @return
	 *	2015��9��25��
	 */
	public static <T> Set<T> union(Set<T> a,Set<T> b){
		Set<T> result=new HashSet<T>(a);
		result.addAll(b);
		return result;
	}
	/**
	 * ���������������еĲ���
	 * @param a
	 * @param b
	 * @return
	 *	2015��9��25��
	 */
	public static <T> Set<T> interSelection(Set<T> a,Set<T> b){
		Set<T> result=new HashSet<T>(a);
		result.retainAll(b);
		return result;
	}
	/**
	 * ����������������ͬ����
	 * @param superSet
	 * @param subSet
	 * @return
	 *	2015��9��25��
	 */
	public static <T> Set<T> dfference(Set<T> superSet,Set<T> subSet){
		Set<T> result=new HashSet<T>(superSet);
		result.removeAll(subSet);
		return result;
	}
	
	/**
	 * ����������������֮���Ԫ��
	 * @param a
	 * @param b
	 * @return
	 *	2015��9��25��
	 */
	
	public static <T> Set<T> complement(Set<T> a,Set<T> b){
		return dfference(union(a,b),interSelection(a,b));
	}
}
