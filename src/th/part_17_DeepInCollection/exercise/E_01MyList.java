package th.part_17_DeepInCollection.exercise;

import java.util.AbstractList;
import java.util.List;

public class E_01MyList extends AbstractList<Integer>{
	private int index;
	
	public E_01MyList(int index){
		this.index=index < 0 ? 0 :index;
	}
	@Override
	public Integer get(int index) {
		return Integer.valueOf(index);
	}

	@Override
	public int size() {
		return index;
	}
	
	public static void main(String[] args) {
		List<Integer> list=new E_01MyList(10);
		System.out.println(list);
	}
}
