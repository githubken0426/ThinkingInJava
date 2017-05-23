package th.part_15_Generic.chapter_04_GenericMethod._04;

import th.util.CountObject;
import th.util.Generator;

public class BaseGeneratorMain {
	public static void main(String[] args) {
		Generator<CountObject> base=BaseGenerator.create(CountObject.class);
		for(int i=0;i<5;i++){
			System.out.println(base.next());
		}
		System.out.println("*************************");
		Generator<CountObject> ob=new BaseGenerator<CountObject>(CountObject.class);
		for(int i=0;i<5;i++){
			System.out.println(ob.next());
		}
	}
}
