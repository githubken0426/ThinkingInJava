package th.part_11_collection.chapter_07LinkedList;

import java.util.Collections;
import java.util.LinkedList;

import th.part_11_collection.chapter_06Iterator.PetsA;

public class LinkedListMain {

	public static void main(String[] args) {
		LinkedList<PetsA> list=new LinkedList<PetsA>();
		PetsA [] pet=new PetsA[]{
				new PetsA(1,"�ϴ�",23),
				new PetsA(2,"�϶�",22),
				new PetsA(3,"����",21),
				new PetsA(4,"����",20)
		};
		Collections.addAll(list,pet);
		System.out.println("list.getFirst():"+list.getFirst().getName());
		System.out.println("list.getLast():"+list.getLast().getName());
		System.out.println("list.element():"+list.element().getName());
		System.out.println("list.peek():"+list.peek().getName());
		if(list.contains("�ϴ�")){
			System.out.println("true");
		}
	}

}
