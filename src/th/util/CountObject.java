package th.util;

public class CountObject {
	private static long counter=0;
	
	private final long id=counter++;
	
	public String toString(){
		return getClass().getSimpleName()+" "+id;
	}
}
