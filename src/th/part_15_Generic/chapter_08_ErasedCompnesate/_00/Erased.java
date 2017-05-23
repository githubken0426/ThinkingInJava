package th.part_15_Generic.chapter_08_ErasedCompnesate._00;

/**
 * 15.8
 * ²Á³ýµÄ²¹³¥
 * 
 * @author ken
 * @param <T>
 * 2016-9-30 ÉÏÎç10:05:28
 */
public class Erased<T> {
	private final int size=100;
	
	public void f(Object obj){
//		if(obj instanceof T){}
//		T var =new T();
//		T[] array=new T[size];
		T[] array=(T[])new Object[size];
	}
}
