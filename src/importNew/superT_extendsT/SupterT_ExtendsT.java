package importNew.superT_extendsT;

import java.util.ArrayList;
import java.util.List;

public class SupterT_ExtendsT {

	/**
	 * <? extends T>表示类型的上界,表示包括T在内的任何T的子类,具有任何从T继承类型的列表
	 * 
	 * 读取：
	 * 你可以读取到Number，因为以上的列表要么包含Number元素，要么包含Number的类元素。
	 * 你不能保证读取到Integer，因为list可能指向的是List<Double>。
	 * 你不能保证读取到Double，因为list可能指向的是List<Integer>。
	 * 
	 * 写入：
	 * 你不能插入一个Integer元素，因为list可能指向List<Double>。
	 * 你不能插入一个Double元素，因为list可能指向List<Integer>。
	 * 你不能插入一个Number元素，因为list可能指向List<Integer>。
	 * 你不能往List<? extends T>中插入任何类型的对象(null对象除外)，因为你不能保证列表实际指向的类型是什么，
	 * 你并不能保证列表中实际存储什么类型的对象。唯一可以保证的是，你可以从中读取到T或者T的子类
	 * 
	 */
	public static void _extendsT(){
		List<? extends Number> list=new ArrayList<Number>();
//		list=new ArrayList<Integer>();
//		list=new ArrayList<Double>();
//		list.add(1.23);
		list.add(null);
		Integer i=(Integer) list.get(0);
		System.out.println("Integer:"+i);
		Double d=(Double) list.get(0);
		System.out.println("Double:"+d);
		Number n=list.get(0);
		System.out.println("Number:"+n);
		Object obj=list.get(0);
		System.out.println("Object:"+obj);
	}
	/**
	 * <? super T> 表示类型下界(Java Core中叫超类型限定),表示包括T在内的任何T的父类，具有任何T的超类型的列表
	 * 
	 * 读取：
	 * 你不能保证读取到Integer，因为list可能指向List<Number>或者List<Object>。
	 * 你不能保证读取到Number，因为list可能指向List<Object>。
	 * 唯一可以保证的是，你可以读取到Object或者Object子类的对象(你并不知道具体的子类是什么)
	 * 
	 * 写入：
	 * 你可以插入Integer对象，因为上述声明的列表都支持Integer。
	 * 你可以插入Integer的子类的对象，因为Integer的子类同时也是Integer，原因同上。
	 * 你不能插入Number对象，因为list可能指向ArrayList<Integer>。
	 * 你不能插入Object对象，因为list可能指向ArrayList<Integer>
	 */
	public static void _superT(){
		List<? super Integer> list=new ArrayList<Integer>();
		list=new ArrayList<Number>();
		list=new ArrayList<Object>();
		list=new ArrayList<Comparable<Integer>>();
		
		list.add(null);
		list.add(1);
//		list.add(1.23);
//		list.add(new Object());
		Number num=new Integer(10);
//		list.add(num);//虽然num指向Integer,但是本质还是Number对象。无法插入
		Integer i=(Integer) list.get(1);
		System.out.println("Integer:"+i);
		Object obj=list.get(0);
		System.out.println("Object:"+obj);
		System.out.println(list.contains(i));//contains()方法
		if(i instanceof Number){
			System.out.println("i instanceof Number:"+(i instanceof Number));
		}
		if(Number.class.isInstance(i)){
			System.out.println("Number.class.isInstance(i):"+(Number.class.isInstance(i)));
		}
		if(Number.class.isAssignableFrom(i.getClass())){
			System.out.println("Number.class.isAssignableFrom(i.getClass()):"
					+(Number.class.isAssignableFrom(i.getClass())));
		}
	}
	public static void main(String[] args) {
		_extendsT();
		System.out.println("================================");
		_superT();
	}
}
