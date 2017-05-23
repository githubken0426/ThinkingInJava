package th.part_15_Generic.exercise;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import th.util.CommonSets;
import th.util.WaterColors;

/**
 * �ܽ���Set�ӿں�EnumSet
 * @author Administrator
 * 2015��9��28��
 */
public class E17_Sets {
	protected static <T> Set<T> copy(Set<T> s){
		if(s instanceof EnumSet)
			return ((EnumSet) s).clone();
		return new HashSet<T>(s);
	}
	
	public static <T> Set<T> union(Set<T> a,Set<T> b){
		Set<T> result=copy(a);
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
		Set<T> result=copy(a);
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
		Set<T> result=copy(superSet);
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
	
	/**
	 * Exercise 17
	 * @param args
	 *	2015��9��28��
	 */
	public static void main(String[] args) {
		Set<WaterColors> set1=EnumSet.range(WaterColors.ZINC,WaterColors.RED);
		Set<WaterColors> set2=EnumSet.range(WaterColors.RED,WaterColors.BLUE);
		System.out.println("set1:"+set1);
		System.out.println("set2:"+set2);
		
		System.out.println("union(set1, set2):"+union(set1, set2));
		
		System.out.println("union(set1, set2) type:"+union(set1, set2).getClass().getSimpleName());
	}
}
