package th.part_11_collection.exercise;

import java.util.LinkedList;
import java.util.ListIterator;

public class E_14AddMiddle {
	
	public static void insertMiddle(int size){
		LinkedList<Integer> list=new LinkedList<Integer>();
		ListIterator<Integer> it=list.listIterator();
		for(int i=0;i<=size;i++){
			it.add(i);
			if(i% 2 ==0)
				it.previous();
		}
		System.out.println(list);
	}
	public static void main(String[] args) {
		insertMiddle(5);
	}
}
