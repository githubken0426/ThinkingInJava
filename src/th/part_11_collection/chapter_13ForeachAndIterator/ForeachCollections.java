package th.part_11_collection.chapter_13ForeachAndIterator;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * java SE5.0������Iterable�ӿڣ��ýӿ�iterator()��������Iterator����
 * ����Iterable�ӿڱ�������foreach�������ƶ�,���Կ���foreach����
 * @author Administrator
 * 2016-4-19 ����11:35:40
 *
 */
public class ForeachCollections {
	public static void main(String[] args) {
		Collection<String> cs=new LinkedList<String>();
		Collections.addAll(cs, ("This is my dog !").split(" "));
		for (String str : cs) {
			System.out.println(str);
		}
	}
}
