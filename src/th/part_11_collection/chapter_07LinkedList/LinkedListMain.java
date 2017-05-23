package th.part_11_collection.chapter_07LinkedList;

import java.util.Collections;
import java.util.LinkedList;

import th.part_11_collection.chapter_06Iterator.PetsA;

public class LinkedListMain {

	public static void main(String[] args) {
		LinkedList<PetsA> list=new LinkedList<PetsA>();
		PetsA [] pet=new PetsA[]{
				new PetsA(1,"老大",23),
				new PetsA(2,"老二",22),
				new PetsA(3,"老三",21),
				new PetsA(4,"老四",20)
		};
		Collections.addAll(list,pet);
		System.out.println("list.getFirst():"+list.getFirst().getName());
		System.out.println("list.getLast():"+list.getLast().getName());
		System.out.println("list.element():"+list.element().getName());
		System.out.println("list.peek():"+list.peek().getName());
		if(list.contains("老大")){
			System.out.println("true");
		}
	}

}
