package th.part_15_Generic.chapter_08_ErasedCompnesate._02;

public class GenericArray2<T> {
	private Object[] array;
	
	public GenericArray2(int size){
		array=new Object[size];
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
		GenericArray2<Integer> gia=new GenericArray2<Integer>(10);
		for(int i=0;i<10;i++){
			gia.put(i, i);
		}
		for(int i=0;i<10;i++)
			System.out.print(gia.get(i)+" ");
		//classcastexception
		Integer[] it=gia.rep();
		
	}
}
