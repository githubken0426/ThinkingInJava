package th.part_16_Array._05_array_generic;

public class ArrayOfGenericType<T> {
	T[] array;
	public ArrayOfGenericType(int size){
//		array=new T[size];//compile error
		array=(T[]) new Object[size];
	}
	//compile error
//	public <T> T[] makeArray(){
//		return new T[10];
//	}
}
