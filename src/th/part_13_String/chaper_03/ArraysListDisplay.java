package th.part_13_String.chaper_03;

import java.util.ArrayList;
import java.util.List;


public class ArraysListDisplay {

	public static void main(String[] args) {
		List<InfiniteRecursion> list=new ArrayList<InfiniteRecursion>();
		for(int i=0;i<3;i++){
			InfiniteRecursion ir=new InfiniteRecursion("Ñ§Éú"+i);
			list.add(ir);
		}
		System.out.println(list);
	}
}
