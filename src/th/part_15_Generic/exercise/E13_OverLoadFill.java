package th.part_15_Generic.exercise;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import th.part_15_Generic.chapter_03_GenericInterface.CoffGenerator;
import th.part_15_Generic.chapter_03_GenericInterface.Coffee;
import th.part_15_Generic.chapter_03_GenericInterface.Fibonacci;
import th.util.Generator;

/**
 * 重载fill()
 * @author Administrator
 * 2015年9月25日
 */
public class E13_OverLoadFill {
	public static <T> List<T> fill(List<T> coll,Generator<T> gen,int n){
		for(int i=0;i<n;i++){
			coll.add(gen.next());
		}
		return coll;
	}
	
	public static <T> LinkedList<T> fill(LinkedList<T> coll,Generator<T> gen,int n){
		for(int i=0;i<n;i++){
			coll.add(gen.next());
		}
		return coll;
	}
	
	public static <T> Queue<T> fill(Queue<T> coll,Generator<T> gen,int n){
		for(int i=0;i<n;i++){
			coll.add(gen.next());
		}
		return coll;
	}
	
	public static <T> Set<T> fill(Set<T> coll,Generator<T> gen,int n){
		for(int i=0;i<n;i++){
			coll.add(gen.next());
		}
		return coll;
	}
	
	public static void main(String[] args) {
		Collection<Coffee> coffee=fill(new ArrayList<Coffee>(),new CoffGenerator(),4);
		for (Coffee c : coffee) {
			System.out.println(c);
		}
		System.out.println("***************************");
		
		Queue<Integer> queue=fill(new LinkedList<Integer>(),new Fibonacci(),12);
		for (Integer i : queue) {
			System.out.println(i);
		}
		System.out.println("***************************");
		LinkedList<Integer> link=fill(new LinkedList<Integer>(),new Fibonacci(),12);
		for (Integer i : link) {
			System.out.println(i);
		}
	}
}
