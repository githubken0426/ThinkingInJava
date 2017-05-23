package th.part_11_collection.chapter_06Iterator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

import TIJ4_code.typeinfo.pets.Pet;
import TIJ4_code.typeinfo.pets.Pets;
/**
 * ���ն��󲢴��������Ӷ���ÿ�������϶�ִ�в���������˼��ʮ��ǿ�󣬲��ᴩ�ڱ���
 * 
 * @author ken
 * 2016-12-23 ����11:52:33
 */
public class CrossContainerIteration {
	public static void display(Iterator<Pet> iterator){
		while(iterator.hasNext()){
			Pet pet=(Pet) iterator.next();
			System.out.println(pet);
		}
	}
	
	/**
	 * display()������Ĵ����Iterator����
	 * ������ͳһ�˶������ķ���
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
