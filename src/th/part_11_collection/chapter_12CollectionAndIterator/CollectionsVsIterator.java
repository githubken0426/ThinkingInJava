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
			System.out.println("������"+pet.getName());
		}
	}
	
	public static void display(Collection<? extends PetsA> col){
		System.out.println("Collections:");
		for (PetsA ele : col) {
			System.out.println("����:"+ele.getName());
		}
	}
	/**
	 * ���ַ�ʽ�����Դ�Ч��CollectionҪ����һЩ����Ϊ����Iterable����
	 * ����ʹ��foreach�ṹ�������������
	 * @param args
	 */
	public static void main(String[] args) {
		List<PetsA> list=new ArrayList<PetsA>();
		PetsA [] pet=new PetsA[]{
				new PetsA(1,"�ϴ�",8),
				new PetsA(2,"�϶�",5),
				new PetsA(3,"����",4)
		};
		
		Collections.addAll(list,pet);
		display(list.iterator());
		Set<PetsA> set=new HashSet<PetsA>(list);
		display(set);
	}
}
