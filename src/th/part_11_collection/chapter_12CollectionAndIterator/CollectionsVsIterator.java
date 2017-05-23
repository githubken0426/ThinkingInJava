package th.part_11_collection.chapter_12CollectionAndIterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import th.part_11_collection.chapter_06Iterator.PetsA;

public class CollectionsVsIterator {
	
	public static void display(Iterator<? extends PetsA> it){
		System.out.println("Iterator:");
		while(it.hasNext()){
			PetsA pet=it.next();
			System.out.println("姓名："+pet.getName());
		}
	}
	
	public static void display(Collection<? extends PetsA> col){
		System.out.println("Collections:");
		for (PetsA ele : col) {
			System.out.println("姓名:"+ele.getName());
		}
	}
	/**
	 * 两种方式都可以凑效，Collection要方便一些，因为他是Iterable类型
	 * 可以使用foreach结构，代码更加清晰
	 * @param args
	 */
	public static void main(String[] args) {
		List<PetsA> list=new ArrayList<PetsA>();
		PetsA [] pet=new PetsA[]{
				new PetsA(1,"老大",8),
				new PetsA(2,"老二",5),
				new PetsA(3,"老三",4)
		};
		
		Collections.addAll(list,pet);
		display(list.iterator());
		Set<PetsA> set=new HashSet<PetsA>(list);
		display(set);
	}
}
