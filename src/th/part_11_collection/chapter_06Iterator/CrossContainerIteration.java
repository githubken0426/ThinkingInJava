package th.part_11_collection.chapter_06Iterator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

import TIJ4_code.typeinfo.pets.Pet;
import TIJ4_code.typeinfo.pets.Pets;
/**
 * 接收对象并传递他，从而在每个对象上都执行操作，这种思想十分强大，并贯穿于本书
 * 
 * @author ken
 * 2016-12-23 上午11:52:33
 */
public class CrossContainerIteration {
	public static void display(Iterator<Pet> iterator){
		while(iterator.hasNext()){
			Pet pet=(Pet) iterator.next();
			System.out.println(pet);
		}
	}
	
	/**
	 * display()无需关心传入的Iterator对象
	 * 迭代器统一了对容器的访问
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Pet> list=Pets.arrayList(2);
		LinkedList<Pet> linkedList=new LinkedList<Pet>(list);
		HashSet<Pet> hashSet=new HashSet<Pet>(list);
		TreeSet<Pet> treeSet =new TreeSet<Pet>(list);
		display(list.iterator());
		System.out.println();
		display(linkedList.iterator());
		System.out.println();
		display(hashSet.iterator());
		System.out.println();
		display(treeSet.iterator());
	}
}
