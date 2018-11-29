package cn;

import java.util.ArrayList;
import java.util.List;

import th.part_14_TypeInfo.chapter_08_NullObject._01.Person;

public class ExtendsTest {
	static class A{
		static {
			System.out.println("A的静态块");
		}
		A(){
			System.out.println("A的构造");
		}
	}
	static class B extends A{
		static {
			System.out.println("B的静态块");
		}
		B(){
			System.out.println("B的构造");
		}
	}
	
	public static void main(String[] args) {
		B b =new B();
		
		
	}
	
	public void test(){
		List<Person> proList=new ArrayList<>();
		
		 // 根据价格过滤
	    proList.stream()
	           .fliter((p) -> p)
	           .limit(2)
	           .forEach(System.out::println);
	}
	   

}
