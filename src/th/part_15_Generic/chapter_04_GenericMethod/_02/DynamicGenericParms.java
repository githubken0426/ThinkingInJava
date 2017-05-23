package th.part_15_Generic.chapter_04_GenericMethod._02;

import java.util.ArrayList;
import java.util.List;

/**
 * �ɱ�������ͷ���
 * @author Administrator
 * 2015��9��24��
 */
public class DynamicGenericParms {
	/**
	 * java.util.Arrays.asList()������ͬ
	 * @param t
	 * @return
	 *	2015��9��24��
	 */
	public static <T> List<T> getList(T ...t){
		 List<T> result=new ArrayList<T>();
		 for (T t2 : t) {
			 result.add(t2);
		}
		 return result;
	}
	
	public static void main(String[] args) {
		List<String> list=getList("a");
		System.out.println(list);
		list=getList("A","B","C");
		System.out.println(list);
	}
}
