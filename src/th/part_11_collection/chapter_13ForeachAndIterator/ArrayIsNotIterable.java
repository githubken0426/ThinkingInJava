package th.part_11_collection.chapter_13ForeachAndIterator;

import java.util.Arrays;

public class ArrayIsNotIterable {
	static <T> void iterable(Iterable<T> iterable){
		for (T t : iterable) {
			System.out.print(t+" ");
		}
	}
	public static void main(String[] args) {
		iterable(Arrays.asList(1,2,3,4));
		String [] str=new String[]{"A","B","C"};
		System.out.println();
		//不能用数组参数，必须是Iterable类型的
//		iterable(str);
		iterable(Arrays.asList(str));
	}
}
