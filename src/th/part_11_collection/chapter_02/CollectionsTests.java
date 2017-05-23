package th.part_11_collection.chapter_02;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionsTests {
	public static void main(String[] args) {
		Collection<Integer> collection =new ArrayList<Integer>();
		//调用Collections工具类的addAll方法
		Collections.addAll(collection,10,11,12,13);
		for (Integer integer : collection) {
			System.out.println(integer);
		}
	}
}
