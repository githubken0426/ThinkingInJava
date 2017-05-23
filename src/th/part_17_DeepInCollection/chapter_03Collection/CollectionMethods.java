package th.part_17_DeepInCollection.chapter_03Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import th.part_17_DeepInCollection.chapter_02Fill._03Abstract.Countries;

/**
 * Collection接口方法
 * @author Administrator
 * 2016-4-22 下午01:57:09
 *
 */
public class CollectionMethods {
	public static void main(String[] args) {
		Collection<String> col=new ArrayList<String>();
		col.addAll(Countries.names(3));
		System.out.println(col);
		col.add("seven");
		System.out.println(col);
		
		Object [] array=col.toArray();
		System.out.println(array);
		
		String [] s=col.toArray(new String[0]);
	
		System.out.println("Collections.max():"+Collections.max(col));
		System.out.println("Collections.min():"+Collections.min(col));
		
		Collection<String> col2=new ArrayList<String>();
		col2.addAll(Countries.names(3));
		col.addAll(col2);
		System.out.println(col);
		
//		col.remove(Countries.DATA[0][0]);
//		System.out.println(col);
		//移出两个collection相同的元素
//		col.removeAll(col2);
		System.out.println( col);
		
		String val=Countries.DATA[2][0];
		System.out.println("col.contains("+val+"):"+col.contains(val));
		System.out.println(col.containsAll(col2));
	}
}
