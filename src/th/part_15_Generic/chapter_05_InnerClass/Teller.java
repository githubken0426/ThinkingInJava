package th.part_15_Generic.chapter_05_InnerClass;

import th.util.Generator;

public class Teller {
	private static  long count=1;
	private final long id=count++;
	
	private Teller(){}
	
	public String toString(){
		return "Teller "+id;
	}
	
	public static Generator<Teller> generator(){
		
		return new Generator(){
			@Override
			public Teller next() {
				return new Teller();
			}
		};
		
	}
}
