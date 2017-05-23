package th.part_17_DeepInCollection.chapter_02Fill._03Abstract;

import java.util.AbstractList;
import java.util.List;

/**
 * ʹ��AbstractList����ֻ����List
 * @author Administrator
 * 2016-4-20 ����04:51:49
 *
 */
public class CountingIntegerList extends AbstractList<Integer>{
	private int size;
	
	public CountingIntegerList(int size){
		this.size=size< 0 ? 0:size;
	}
	
	@Override
	public Integer get(int index) {
		return Integer.valueOf(index);
	}

	@Override
	public int size() {
		return size;
	}
	
	public static void main(String[] args) {
		List<Integer> list=new CountingIntegerList(10);
		System.out.println(list);
	}
}
