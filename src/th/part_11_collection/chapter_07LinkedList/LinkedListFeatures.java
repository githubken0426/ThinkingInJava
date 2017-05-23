package th.part_11_collection.chapter_07LinkedList;

import java.util.Arrays;
import java.util.LinkedList;
/**
 * ArrayList�ڲ���ͨ��һ��̬���ݴ洢�ġ����Բ������ݺܿ졣����INDEX��������Ч�ʸߡ����ݴ洢�������С�
	LinkedList�����ݸ���û�й̶��������洢������ͨ������������ã�һ��һ��������ȥ�ġ�
	�򵥵�˵�����Ǳ�����һ����������������У��������ж���ȡ���������Ĵ�С�� �������ݽṹ���£�
	Entry<E> {
		E element;
		Entry<E> previous;
		Entry<E> next;
	}
	���������ǲ��һ��ǲ��룬ɾ������Ҫ�ӵ�һ��Ԫ���ݿ�ʼ�ҡ�����Ч����Ȼ�ͺܵ͡�
	�кܶ���˵��LinkedList����Ч�ʱ�ArrayListЧ�ʲ��������ӻ�ɾ��Ч�ʱ�ArrayList�ߡ�
	ǰ�ߺܺ���⡣�����Ҳ����ˣ�LinkedList��ô��Ч�ʲ��ߡ�������ӻ�ɾ��Ч��Ҳ����ArrayList�ߡ�
	�����û���ù�LinkedList����������ʲô�ô����ҿ����������ݽṹ��Ƶ������࣬ʵ���Ϻ����ã���֪����ʲô�á� 
	Ψһ�����и��ô�����������JDK����ƻ������ʱ����
 * @author ken
 * 2016-12-27 ����03:58:57
 */

public class LinkedListFeatures {
	public static void main(String[] args) {
		LinkedList<String> linkedList=new LinkedList<String>(Arrays.asList("Ԫ��_1","Ԫ��_2","Ԫ��_3"));
		System.out.println(linkedList);
		System.out.println("getFirst():"+linkedList.getFirst());
		/**
		 * ���ص�һ��Ԫ�أ���getFirst()����,Ԫ��Ϊ��ʱ���׳��쳣��NoSuchElementException
		 */
		System.out.println("element():"+linkedList.element());
		System.out.println("remove():"+linkedList.remove());
		//removeFirst()�Ƴ��������б��ͷ��Ԫ��
		System.out.println("removeFirst():"+linkedList.removeFirst());
		//removeAll()�Ƴ��������ݷ���true
//		System.out.println("removeAll():"+linkedList.removeAll(linkedList));
		/**
		 * Ԫ��Ϊ��ʱ�����null�����׳��쳣
		 * peek()����ɾ����ǰԪ�أ�poll()ɾ����ǰԪ��
		 */
		System.out.println("peek:"+linkedList.peek());
		System.out.println("peek:"+linkedList);
		System.out.println("poll():"+linkedList.poll());
		System.out.println("poll():"+linkedList);
		
		
		/**
		 * offer(E e)��ָ��Ԫ����ӵ����б��ĩβ(���һ��Ԫ��)
		 * ��ͬaddLast("bbb");
		 */
		linkedList.offer("abc");
		linkedList.addLast("bbb");
		System.out.println("After offer():"+linkedList);
		
		linkedList.set(linkedList.size()-1, "replace!");
		System.out.println(linkedList);
	}
}
