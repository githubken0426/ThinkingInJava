package importNew.superT_extendsT;

import java.util.ArrayList;
import java.util.List;

public class SupterT_ExtendsT {

	/**
	 * <? extends T>��ʾ���͵��Ͻ�,��ʾ����T���ڵ��κ�T������,�����κδ�T�̳����͵��б�
	 * 
	 * ��ȡ��
	 * ����Զ�ȡ��Number����Ϊ���ϵ��б�Ҫô����NumberԪ�أ�Ҫô����Number����Ԫ�ء�
	 * �㲻�ܱ�֤��ȡ��Integer����Ϊlist����ָ�����List<Double>��
	 * �㲻�ܱ�֤��ȡ��Double����Ϊlist����ָ�����List<Integer>��
	 * 
	 * д�룺
	 * �㲻�ܲ���һ��IntegerԪ�أ���Ϊlist����ָ��List<Double>��
	 * �㲻�ܲ���һ��DoubleԪ�أ���Ϊlist����ָ��List<Integer>��
	 * �㲻�ܲ���һ��NumberԪ�أ���Ϊlist����ָ��List<Integer>��
	 * �㲻����List<? extends T>�в����κ����͵Ķ���(null�������)����Ϊ�㲻�ܱ�֤�б�ʵ��ָ���������ʲô��
	 * �㲢���ܱ�֤�б���ʵ�ʴ洢ʲô���͵Ķ���Ψһ���Ա�֤���ǣ�����Դ��ж�ȡ��T����T������
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
	 * <? super T> ��ʾ�����½�(Java Core�нг������޶�),��ʾ����T���ڵ��κ�T�ĸ��࣬�����κ�T�ĳ����͵��б�
	 * 
	 * ��ȡ��
	 * �㲻�ܱ�֤��ȡ��Integer����Ϊlist����ָ��List<Number>����List<Object>��
	 * �㲻�ܱ�֤��ȡ��Number����Ϊlist����ָ��List<Object>��
	 * Ψһ���Ա�֤���ǣ�����Զ�ȡ��Object����Object����Ķ���(�㲢��֪�������������ʲô)
	 * 
	 * д�룺
	 * ����Բ���Integer������Ϊ�����������б�֧��Integer��
	 * ����Բ���Integer������Ķ�����ΪInteger������ͬʱҲ��Integer��ԭ��ͬ�ϡ�
	 * �㲻�ܲ���Number������Ϊlist����ָ��ArrayList<Integer>��
	 * �㲻�ܲ���Object������Ϊlist����ָ��ArrayList<Integer>
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
//		list.add(num);//��Ȼnumָ��Integer,���Ǳ��ʻ���Number�����޷�����
		Integer i=(Integer) list.get(1);
		System.out.println("Integer:"+i);
		Object obj=list.get(0);
		System.out.println("Object:"+obj);
		System.out.println(list.contains(i));//contains()����
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
