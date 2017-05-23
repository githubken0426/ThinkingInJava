package th.part_15_Generic.chapter_04_GenericMethod._05;

import th.part_15_Generic.chapter_02_SimpleGeneric._01_Tuple.ThreeTuple;
import th.part_15_Generic.chapter_02_SimpleGeneric._01_Tuple.TwoTuple;
import th.util.CountObject;

public class TupleMain {
	static TwoTuple<String,Integer> f(){
		return SimpleTuple.tuple("Hi",47);
	}
	
	static ThreeTuple<CountObject, String,Integer> h(){
		return SimpleTuple.tuple(new CountObject(),"Hi",47);
	}
	public static void main(String[] args) {
		System.out.println(f());
		System.out.println(h());
	}

}
