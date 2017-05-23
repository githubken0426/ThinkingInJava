package th.part_15_Generic.chapter_07_Erased._04;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15.7.4 �߽�Ķ���
 * @author Administrator
 * 2015��10��9��
 */
public class ArrayMaker<T> {
	private Class<T> t;
	
	public ArrayMaker(Class<T> t){
		this.t=t;
	}
	/**
	 * ArrayMaker���洢ΪClass<T>�����ڲ�����ԭ��ʵ�ʴ洢ΪClass,û���κβ���
	 * ��˵�ʹ��Array.newInstance��������ʱ��û��ӵ�����̺���������Ϣ��
	 * 
	 * �����д������� Array.newInstance�������Ƽ��ķ�ʽ
	 * @param size
	 * @return
	 *	2015��10��9��
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
