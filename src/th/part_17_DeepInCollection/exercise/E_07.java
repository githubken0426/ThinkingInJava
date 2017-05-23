package th.part_17_DeepInCollection.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import th.part_17_DeepInCollection.chapter_02Fill._03Abstract.Countries;

public class E_07 {
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>(Countries.names(3));
		ListIterator<String> itList=list.listIterator(list.size());
		while(itList.hasPrevious()){
			System.out.println(itList.previous());
		}
		System.out.println("*********LinkedList:");
		List<String> linkedList=new ArrayList<String>(Countries.names(3));
		ListIterator<String> itLinked=linkedList.listIterator(linkedList.size());
		while(itLinked.hasPrevious()){
			System.out.println(itLinked.previous());
		}
		
		int index=0;
		for(ListIterator<String> it2=linkedList.listIterator();it2.hasNext();){
			String str=it2.next();
			list.add(index,str);
			index+=2;
		}
		System.out.println(list);
	}
}
