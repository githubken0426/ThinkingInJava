package th.part_11_collection.chapter_11Queue;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;


public class PriorityQueueDemo {
	/**
	 * ����PriorityQueue�ϵ���offer()����ʱ�򣬲���Ķ�����ڶ���������
	 * Ҳ����ͨ���ṩ�Լ���Comparator���޸�����
	 * PriorityQueue����ȷ�������peek().poll(),remove()����ʱ��
	 * ��ȡ��Ԫ���Ƕ��������ȼ���ߵġ�
	 * @param args
	 */
	public static <T> void iterator(Collection<T> c){
		Iterator<T> it=c.iterator();
		while(it.hasNext()){
			Object obj=it.next();
			System.out.print(obj+",");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		PriorityQueue<Integer> priority=new PriorityQueue<Integer>();
		Random random=new Random(47);
		for(int i=0;i<10;i++){
			priority.offer(random.nextInt(i+10));
		}
		iterator(priority);
//		QueueDemo.print(priority);
		
		/**
		 * ��Сֵӵ��������ȼ�
		 */
		Integer data[]=new Integer[]{12,2,3,14,32,4,15,6,8,10};
		PriorityQueue<Integer> queInteger=new PriorityQueue<Integer>(data.length);
		queInteger.addAll(Arrays.asList(data));
//		QueueDemo.print(queInteger);
		iterator(queInteger);
		/**
		 * �ո����ĸ�и������ȼ�
		 * Collections.reverseOrder()��������
		 */
		System.out.println("String�����ո�");
		String str="this the test demo!";
		PriorityQueue<String> que=new PriorityQueue<String>
			(Arrays.asList(str.split("")).size(),Collections.reverseOrder());
		que.addAll(Arrays.asList(str.split("")));
//		QueueDemo.print(que);
		iterator(que);
		
		System.out.println("Set:");
		Set<Character> set=new HashSet<Character>();
		for (char s : str.toCharArray()) {
			set.add(s);
		}
		PriorityQueue<Character> setQueue=new PriorityQueue<Character>();
		setQueue.addAll(set);
//		QueueDemo.print(setQueue);
		iterator(setQueue);
		
	}
}
