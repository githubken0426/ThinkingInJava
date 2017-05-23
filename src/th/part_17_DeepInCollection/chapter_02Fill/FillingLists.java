package th.part_17_DeepInCollection.chapter_02Fill;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FillingLists {
	public static void main(String[] args) {
		/**
		 * nCopies(n,Object)创建n个Object
		 */
		List<StringAddress> list=new ArrayList<StringAddress>
			(Collections.nCopies(3, new StringAddress("hello")));
		System.out.println(list);
		/**
		 * fill()替换list中的元素，他只能替换已有的元素，而不能添加新的元素
		 */
		Collections.fill(list, new StringAddress("word"));
		System.out.println(list);
	}
}
