package th.part_11_collection.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class E_12ListIterator {
	
	public static void reversed(List<Integer> list){
		ListIterator<Integer> it1=list.listIterator();
		//�������Ϊ���ϵĳ��ȣ������α�����ʼ
		ListIterator<Integer> it2=list.listIterator(list.size());
		int mid=list.size()>>1;//�����������num >> 1,�൱��num����2
		for(int i=0;i<mid;i++){
			Integer temp=it1.next();
			Integer tempPre=it2.previous();
			it1.set(tempPre);
			it2.set(temp);
		}
		
	}
	public static void main(String[] args) {
		List<Integer> list1=new ArrayList<Integer>();
		for(int i=0;i<10;i++)
			list1.add(i+10);
		//����ͬ����С�ļ���
		List<Integer> list2=new ArrayList<Integer>(list1.size());
		
		ListIterator<Integer> it=list1.listIterator();
		while(it.hasNext()){
			int n= it.next();
			System.out.print(n+" ,");
		}
		
		while(it.hasPrevious()){
			int n=it.previous();
			list2.add(n);
		}
		
		System.out.println("\n"+list2.toString());
		
		reversed(list1);
		System.out.println(list2.toString());
	}
}
