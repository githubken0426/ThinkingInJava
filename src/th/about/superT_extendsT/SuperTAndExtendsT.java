package th.about.superT_extendsT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SuperTAndExtendsT {

	public static void main(String[] args) {
		/**
		 * 1.����Զ�ȡ��Number�����ϵ��б����NumberԪ�ء��㲻�ܱ�֤��ȡ��Integer��
		 * 	��Ϊfoo3����ָ�����List<Double>���㲻�ܱ�֤��ȡ��Double��
		 * 	��Ϊfoo3����ָ�����List<Integer>��
		 * 2.�㲻�ܲ������ݣ��㲢���ܱ�֤�б���ʵ�ʴ洢ʲô���͵Ķ���
		 * 	Ψһ���Ա�֤���ǣ�����Դ��ж�ȡ��T����T������
		 */
		List<? extends Number> foo1 =new ArrayList<Number>();
		List<? extends Number> foo2 = new ArrayList<Integer>();
		List<? extends Number> foo3 = new ArrayList<Double>();
//		foo3.add(23.00);
		
		/**
		 * 1.�㲻�ܱ�֤��ȡ��Integer����Ϊfoo3����ָ��List<Number>����List<Object>��
		 * 	�㲻�ܱ�֤��ȡ��Number����Ϊfoo3����ָ��List<Object>��
		 * 	Ψһ���Ա�֤���ǣ�����Զ�ȡ��Object����Object����Ķ���
		 * 2.����Բ���Integer������Ϊ�����������б�֧��Integer��
		 * 	����Բ���Integer������Ķ�����ΪInteger������ͬʱҲ��Integer��ԭ��ͬ�ϡ�
		 * 	�㲻�ܲ���Double������Ϊfoo3����ָ��ArrayList<Integer>��
		 * 	�㲻�ܲ���Number������Ϊfoo3����ָ��ArrayList<Integer>��
		 * 	�㲻�ܲ���Object������Ϊfoo3����ָ��ArrayList<Integer>
		 */
		List<? super Integer> foos1 = new ArrayList<Integer>();
		foos1.add(1);
		List<? super Integer> foos2 = new ArrayList<Number>();
		List<? super Integer> foos3 = new ArrayList<Object>();
		
		//���סPECSԭ�������ߣ�Producer��ʹ��extends�������ߣ�Consumer��ʹ��super
		//���Ӳ���jdk1.7 Collections copy����
		Collections.copy(new ArrayList(), new ArrayList());
	}
}
