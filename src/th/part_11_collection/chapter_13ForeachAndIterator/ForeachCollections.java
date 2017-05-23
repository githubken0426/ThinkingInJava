package th.part_11_collection.chapter_13ForeachAndIterator;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * java SE5.0引入了Iterable接口，该接口iterator()方法返回Iterator对象
 * 并且Iterable接口被用来在foreach序列中移动,所以可用foreach遍历
 * @author Administrator
 * 2016-4-19 上午11:35:40
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
