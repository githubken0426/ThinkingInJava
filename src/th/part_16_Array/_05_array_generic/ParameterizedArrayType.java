package th.part_16_Array._05_array_generic;

import java.util.Arrays;
/**
 * 泛型数组
 * 参数化类和参数化方法
 * @author Administrator
 * 2015年11月6日
 */
public class ParameterizedArrayType {
	public static void main(String[] args) {
		Integer [] ints={1,2,3,4,5};
		Double [] d={1.1,2.2,3.3,4.4,5.5};
		Integer[] ints2=new ClassParameter<Integer>().f(ints);
		System.out.println("参数化类——ints2:"+Arrays.deepToString(ints2));
		
		Double[]d2=new ClassParameter<Double>().f(d);
		System.out.println("参数化类——d2:"+Arrays.deepToString(d2));
		//参数化方法更明了些
		ints2=MethodParameter.f(ints);
		System.out.println("参数方法——ints2_2:"+Arrays.deepToString(ints2));
		
		d2=MethodParameter.f(d);
		System.out.println("参数方法——d2_2:"+Arrays.deepToString(d2));
	}
}
