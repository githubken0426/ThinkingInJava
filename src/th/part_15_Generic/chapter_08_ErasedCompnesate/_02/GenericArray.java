package th.part_15_Generic.chapter_08_ErasedCompnesate._02;

public class GenericArray<T> {
	private T[] t;
	
	@SuppressWarnings("unchecked")//此注解等于javac -Xlint:unchecked GenericArray.java
	public GenericArray(int size){
		t=(T[]) new Object[size];
	}
	public void put(int index,T item){
		t[index]=item;
	}
	public T get(int index){
		return t[index];
	}
	public T[] rep(){
		return t;
	}
	    
	public static void main(String[] args) {
		GenericArray<Integer> gia=new GenericArray<Integer>(10);
		//ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.Integer
//		Integer[] ia=gia.rep();
		Object[] obj=gia.rep();
	}
}
