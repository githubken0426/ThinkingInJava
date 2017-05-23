package th.part_15_Generic.chapter_07_Erased._04;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15.7.4 边界的动作
 * @author Administrator
 * 2015年10月9日
 */
public class ArrayMaker<T> {
	private Class<T> t;
	
	public ArrayMaker(Class<T> t){
		this.t=t;
	}
	/**
	 * ArrayMaker被存储为Class<T>，由于擦除的原因，实际存储为Class,没有任何参数
	 * 因此当使用Array.newInstance创建数组时并没有拥有所蕴含的类型信息。
	 * 
	 * 泛型中创建数组 Array.newInstance方法是推荐的方式
	 * @param size
	 * @return
	 *	2015年10月9日
	 */
	T[] create(int size){
		return (T[]) Array.newInstance(t, size);
	}
	
	static class ListMaker<T>{
		
		List<T> create(){
			return new ArrayList<T>();
		}
	}
	public static void main(String[] args) {
		ArrayMaker<String> arrayMaker=new ArrayMaker<String>(String.class);
		String [] string=arrayMaker.create(9);
		System.out.println(Arrays.toString(string));
		
		ListMaker<String> list=new ListMaker<String>(); 
		list.create();
		System.out.println(list);
	}
}
