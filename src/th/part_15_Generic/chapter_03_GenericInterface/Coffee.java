package th.part_15_Generic.chapter_03_GenericInterface;

public class Coffee {
	private static long counter=0;
	
	private final long id=counter++;
	
	public String toString(){
		return getClass().getSimpleName()+" "+id;
	}
	
	static class Latte extends Coffee{}
	static class Mocha extends Coffee{}
	static class Cappuccino extends Coffee{}
}
