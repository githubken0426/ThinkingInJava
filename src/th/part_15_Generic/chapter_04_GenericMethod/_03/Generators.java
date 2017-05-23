package th.part_15_Generic.chapter_04_GenericMethod._03;

import java.util.ArrayList;
import java.util.Collection;

import th.part_15_Generic.chapter_03_GenericInterface.CoffGenerator;
import th.part_15_Generic.chapter_03_GenericInterface.Coffee;
import th.part_15_Generic.chapter_03_GenericInterface.Fibonacci;
import th.util.Generator;
/**
 * Generator的泛型方法
 * @author Administrator
 * 2015年9月25日
 */
public class Generators {
	public static <T> Collection<T> fill(Collection<T> coll,Generator<T> gen,int n){
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
		Collection<Integer> numbers=fill(new ArrayList<Integer>(),new Fibonacci(),12);
		for (Integer i : numbers) {
			System.out.println(i);
		}
	}
}
