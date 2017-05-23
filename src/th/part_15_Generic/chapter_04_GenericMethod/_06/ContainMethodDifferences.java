package th.part_15_Generic.chapter_04_GenericMethod._06;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import th.util.CommonSets;

/**
 * Collection���Map�෽��֮�����
 * @author Administrator
 * 2015��9��28��
 */
public class ContainMethodDifferences {
	/**
	 * ���ط�����Set����
	 * @param type
	 * @return
	 *	2015��9��28��
	 */
	static Set<String> method(Class<?> type){
		Set<String> result=new TreeSet<String>();
		for (Method m : type.getMethods()) {
			result.add(m.getName());
		}
		return result;
	}
	
	static void interfaces(Class<?> type){
		System.out.print("Interfaces in "+type.getSimpleName()+":");
		List<String> result=new ArrayList<String>();
		for (Class<?> c : type.getInterfaces()) {
			result.add(c.getSimpleName());
		}
		System.out.println(result);
	}
	
	static Set<String> obj=method(Object.class);
	static {
		obj.add("clone");
	}
	/**
	 * ���ز�ͬ����������
	 * @param superset
	 * @param subset
	 *	2015��9��28��
	 */
	static void difference(Class<?> superSet,Class<?> subSet){
		System.out.print(superSet.getSimpleName()+" extends "+subSet.getSimpleName()+",adds: ");
		Set<String> comp =CommonSets.dfference(method(superSet), method(subSet));
		comp.removeAll(obj);
		System.out.println(comp);
		interfaces(superSet);
	}
	
	public static void main(String[] args) {
		
		System.out.println("Collection:"+method(Collection.class));
		interfaces(Collection.class);
		difference(Set.class,Collection.class);
		
		difference(HashSet.class,Set.class);
		
		difference(TreeSet.class,Set.class);
	}
}
