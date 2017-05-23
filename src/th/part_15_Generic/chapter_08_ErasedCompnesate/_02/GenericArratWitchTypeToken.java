package th.part_15_Generic.chapter_08_ErasedCompnesate._02;

import java.lang.reflect.Array;

public class GenericArratWitchTypeToken<T> {
	private T[] array;
	
	public GenericArratWitchTypeToken(Class<?> t,int size){
		array=(T[]) Array.newInstance(t,size);
	}
	public void put(int index,T item){
		array[index]=item;
	}
	public T get(int index){
		return (T) array[index];
	}
	public T[] rep(){
		return (T[]) array;
	}
	
	public static void main(String[] args) {
		GenericArratWitchTypeToken<Integer> gia=new GenericArratWitchTypeToken<Integer>(Integer.class,10);
		//this now works
		Integer[] i=gia.rep();
		
	}
}
