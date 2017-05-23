package th.part_17_DeepInCollection.chapter_04Unsupported;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Unsupported {
	static void test(String msg,List<String> list){
		System.out.println("参数："+msg);
		Collection<String> c=list;
		Collection<String> subList=list.subList(1, 8);
		Collection<String> c2=new ArrayList<String>(subList);
		//retainAll
		try {
			c.retainAll(c2);
		} catch (Exception e) {
			System.out.println("reatinAll():"+e);
		}
		//removeAll
		try {
			c.removeAll(c2);
		} catch (Exception e) {
			System.out.println("removeAll():"+e);
		}
		//retainAll
		try {
			c.retainAll(c2);
		} catch (Exception e) {
			System.out.println("reatinAll():"+e);
		}
		//clear
		try {
			c.clear();
		} catch (Exception e) {
			System.out.println("clear():"+e);
		}
		//add
		try {
			c.add("cd");
		} catch (Exception e) {
			System.out.println("add():"+e);
		}
		//addAll
		try {
			c.addAll(c2);
		} catch (Exception e) {
			System.out.println("addAll():"+e);
		}
		//remove
		try {
			c.remove("c");
		} catch (Exception e) {
			System.out.println("remove():"+e);
		}
		//set
		try {
			list.set(0, "X");
		} catch (Exception e) {
			System.out.println("list.set():"+e);
		}
	}
	
	public static void main(String[] args) {
		List<String> list=Arrays.asList("A B C D E F G H I J K L".split(" "));
		test("Modfiable copy",new ArrayList<String>(list));
		
		/**
		 * Arrays.asList()返回的底层还是数组，可以看成固定尺寸的list
		 */
		System.out.println();
		test("Arrays.asList:",list);
		
		/**
		 * unmodifiableList不可变list，任何对list的操作都会触发UnsupportedOperatiionException;
		 */
		System.out.println();
		test("UnmodifiableList:",Collections.unmodifiableList(new ArrayList<String>(list)));
	}
}
