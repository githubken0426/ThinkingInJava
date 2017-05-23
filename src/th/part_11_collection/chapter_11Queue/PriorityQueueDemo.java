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
	 * 当在PriorityQueue上调用offer()方法时候，插入的对象会在队列中排序。
	 * 也可以通过提供自己的Comparator来修改排序。
	 * PriorityQueue可以确保你调用peek().poll(),remove()方法时候，
	 * 获取的元素是队列中优先级最高的。
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
		 * 最小值拥有最高优先级
		 */
		Integer data[]=new Integer[]{12,2,3,14,32,4,15,6,8,10};
		PriorityQueue<Integer> queInteger=new PriorityQueue<Integer>(data.length);
		queInteger.addAll(Arrays.asList(data));
//		QueueDemo.print(queInteger);
		iterator(queInteger);
		/**
		 * 空格比字母有更高优先级
		 * Collections.reverseOrder()产生反序
		 */
		System.out.println("String包含空格：");
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
