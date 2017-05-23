package th.part_17_DeepInCollection.chapter_06Set;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class.newInstance() 只能够调用无参的构造函数，即默认的构造函数
 * Constructor.newInstance() 可以根据传入的参数，调用任意构造构造函数
 * @author Administrator
 * 2016-4-26 上午10:51:40
 *
 */
public class TypeForSets {
	
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
	
	static <T> void  test(Set<T> set,Class<T> type){
		fill(set,type);
		//尝试添加重复元素
		fill(set,type);
		
		System.out.println(set);
	}
	
	public static void main(String[] args) {
		System.out.println("HashSet:");
		test(new HashSet<HashType>(),HashType.class);
		test(new HashSet<SetType>(),SetType.class);
		test(new HashSet<TreeType>(),TreeType.class);
		
		System.out.println("LinkedHashSet:");
		test(new LinkedHashSet<HashType>(),HashType.class);
		test(new LinkedHashSet<SetType>(),SetType.class);
		test(new LinkedHashSet<TreeType>(),TreeType.class);
		
		test(new TreeSet<TreeType>(),TreeType.class);
//		test(new TreeSet<HashType>(),HashType.class);
//		test(new TreeSet<SetType>(),SetType.class);
		
		try {
			Constructor<String> c=String.class.getConstructor(String.class);
			System.out.println(c.newInstance("test"));
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
