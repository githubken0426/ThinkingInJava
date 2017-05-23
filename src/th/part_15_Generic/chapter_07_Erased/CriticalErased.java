package th.part_15_Generic.chapter_07_Erased;

import java.util.ArrayList;
import java.util.List;

/**
 * 上、下边界
 * 
 * @author ken
 * 2017-5-17 上午11:12:09
 */
public class CriticalErased {
	public static void main(String[] args) {
		List<? extends Number> list=new ArrayList<Number>();
		list=new ArrayList<Double>();
		list=new ArrayList<Float>();
		list=new ArrayList<Integer>();
		
		//compile error:只读：有可能指向Number、Double、Float、Integer，所以不能添加任何东西
//		list.add(Integer.valueOf(1));
		Number n1=list.get(0);//只能读取到Number类型
		//compile error
//		Integer n2=list.get(0);
		
		List<? super Integer> list2=new ArrayList<Integer>();
		list2=new ArrayList<Number>();
		list2=new ArrayList<Object>();
		//compile error:
//		Integer i=list2.get(0);
//		list2.add(new Double(20.00));
		//可以插入Integer的子类的对象
		list2.add(Integer.valueOf(10));
	}
}
