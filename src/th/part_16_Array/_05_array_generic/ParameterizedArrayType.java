package th.part_16_Array._05_array_generic;

import java.util.Arrays;
/**
 * ��������
 * ��������Ͳ���������
 * @author Administrator
 * 2015��11��6��
 */
public class ParameterizedArrayType {
	public static void main(String[] args) {
		Integer [] ints={1,2,3,4,5};
		Double [] d={1.1,2.2,3.3,4.4,5.5};
		Integer[] ints2=new ClassParameter<Integer>().f(ints);
		System.out.println("�������ࡪ��ints2:"+Arrays.deepToString(ints2));
		
		Double[]d2=new ClassParameter<Double>().f(d);
		System.out.println("�������ࡪ��d2:"+Arrays.deepToString(d2));
		//����������������Щ
		ints2=MethodParameter.f(ints);
		System.out.println("������������ints2_2:"+Arrays.deepToString(ints2));
		
		d2=MethodParameter.f(d);
		System.out.println("������������d2_2:"+Arrays.deepToString(d2));
	}
}
