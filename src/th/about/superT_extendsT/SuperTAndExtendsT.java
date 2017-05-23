package th.about.superT_extendsT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SuperTAndExtendsT {

	public static void main(String[] args) {
		/**
		 * 1.你可以读取到Number，以上的列表包含Number元素。你不能保证读取到Integer，
		 * 	因为foo3可能指向的是List<Double>。你不能保证读取到Double，
		 * 	因为foo3可能指向的是List<Integer>。
		 * 2.你不能插入数据，你并不能保证列表中实际存储什么类型的对象。
		 * 	唯一可以保证的是，你可以从中读取到T或者T的子类
		 */
		List<? extends Number> foo1 =new ArrayList<Number>();
		List<? extends Number> foo2 = new ArrayList<Integer>();
		List<? extends Number> foo3 = new ArrayList<Double>();
//		foo3.add(23.00);
		
		/**
		 * 1.你不能保证读取到Integer，因为foo3可能指向List<Number>或者List<Object>。
		 * 	你不能保证读取到Number，因为foo3可能指向List<Object>。
		 * 	唯一可以保证的是，你可以读取到Object或者Object子类的对象
		 * 2.你可以插入Integer对象，因为上述声明的列表都支持Integer。
		 * 	你可以插入Integer的子类的对象，因为Integer的子类同时也是Integer，原因同上。
		 * 	你不能插入Double对象，因为foo3可能指向ArrayList<Integer>。
		 * 	你不能插入Number对象，因为foo3可能指向ArrayList<Integer>。
		 * 	你不能插入Object对象，因为foo3可能指向ArrayList<Integer>
		 */
		List<? super Integer> foos1 = new ArrayList<Integer>();
		foos1.add(1);
		List<? super Integer> foos2 = new ArrayList<Number>();
		List<? super Integer> foos3 = new ArrayList<Object>();
		
		//请记住PECS原则：生产者（Producer）使用extends，消费者（Consumer）使用super
		//例子参照jdk1.7 Collections copy方法
		Collections.copy(new ArrayList(), new ArrayList());
	}
}
