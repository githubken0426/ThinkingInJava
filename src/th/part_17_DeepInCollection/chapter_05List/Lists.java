package th.part_17_DeepInCollection.chapter_05List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import th.part_17_DeepInCollection.chapter_02Fill._03Abstract.Countries;

public class Lists {
	private static boolean b;
	private static String s;
	private static int i;
	private static Iterator<String> iterator;
	private static ListIterator<String> listIteratro;
	
	public static void basicTest(List<String> list){
		System.out.println("Before Operation:"+list);
		list.add(1,"XS");
		list.add("x");
		list.addAll(Countries.names(3));
		list.addAll(3,Countries.names(3));
		System.out.println(list);
		b=list.contains("1");
		System.out.println("list.contains('1'):"+b);
		b=list.containsAll(Countries.names(3));
		System.out.println("list.containsAll(Countries.names(3)):"+b);
		s=list.get(1);
		System.out.println("list.get(1):"+s);
		i=list.indexOf("1");
		System.out.println("list.indexOf(1):"+i);
		b=list.isEmpty();
		System.out.println("list.isEmpty():"+b);
		iterator=list.iterator();
		listIteratro=list.listIterator();
		//从第三位元素便利
		listIteratro=list.listIterator(3);
		i=list.lastIndexOf("1");
		list.remove(1);
		System.out.println("list.remove(1):"+list);
		list.remove("3");
		System.out.println("list.remove('3'):"+list);
		list.set(1, "y");
		list.removeAll(Countries.names(3));
		i=list.size();
		list.clear();
		System.out.println(list);
	}
	
	public static void iterMontion(List<String> list){
		ListIterator<String> it=list.listIterator();
		b=it.hasNext();
		b=it.hasPrevious();
		s=it.next();
		i=it.nextIndex();
		s=it.previous();
		i=it.previousIndex();
	}
	
	public static void iterManipulation(List<String> list) {
		ListIterator<String> it=list.listIterator();
		it.add("47");
		it.next();
		it.remove();//移除当前游标指向的元素
		it.next(); //remove()操作后，必须移动游标到下一个元素
		it.set("47");
	}
	
	public static void testVisual(List<String> list){
		System.out.println(list);
		List<String> b=Countries.names(3);
		System.out.println("b="+b);
		list.addAll(b);
		list.addAll(b);
		System.out.println(list);
		ListIterator<String> x=list.listIterator(list.size()/2);
		x.add("one");
		System.out.println(list);
		System.out.println(x.next());
		x.set("47");
		System.out.println(list);
		x=list.listIterator(list.size());
		while(x.hasPrevious())
			System.out.println(x.previous()+" ");
	}
	
	/**
	 * 测试LinkedList
	 */
	public static void testLinkedList(){
		LinkedList<String> list=new LinkedList<String>();
		list.addAll(Countries.names(3));
		System.out.println(list);
		list.addFirst("one");
		list.addFirst("two");
		System.out.println(list);
		System.out.println("list.getFirst():"+list.getFirst());
		System.out.println(list.removeFirst());
		System.out.println(list.removeFirst());
		System.out.println(list.removeLast());
	}
	
	public static void main(String[] args) {
		
		System.out.println("1:**********************************");
		basicTest(new LinkedList<String>(Countries.names(3)));
		System.out.println("2:**********************************");
		basicTest(new ArrayList<String>(Countries.names(3)));
		
//		System.out.println("3:**********************************");
//		iterMontion(new LinkedList<String>(Countries.names(3)));
//		iterMontion(new ArrayList<String>(Countries.names(3)));
//		
//		System.out.println("4:**********************************");
//		iterManipulation(new LinkedList<String>(Countries.names(3)));
//		iterManipulation(new ArrayList<String>(Countries.names(3)));
//		
//		System.out.println("5:**********************************");
//		testVisual(new LinkedList<String>(Countries.names(3)));
//		testLinkedList();
	}
}
