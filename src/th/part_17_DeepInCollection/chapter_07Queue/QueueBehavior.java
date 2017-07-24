package th.part_17_DeepInCollection.chapter_07Queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
//import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

import TIJ4_code.net.mindview.util.Generator;

public class QueueBehavior {
	private static int count =10;
	
	static <T> void test(Queue<T> queue,Generator<T> gen){
		for(int i =0;i<count;i++)
			queue.offer(gen.next());
		while(queue.peek()!=null)
			System.out.print(queue.remove()+",");
	}
	
	static class Gen implements Generator<String>{
		String str[]="one two three four five six seven eight nine ten".split(" ");
		int i;
		@Override
		public String next() {
			return str[i++];
		}
	}
	/**
	 * 队列是一种特殊的线性表，是一种先进先出（FIFO）的数据结构。
	 * 它只允许在表的前端（front）进行删除操作，而在表的后端（rear）进行插入操作
	 * 队列空的条件：front=rear
	 * 队列满的条件： rear = MAXSIZE
	 * @param args
	 * @throws 
	 * @date 2017年7月24日 上午8:44:05
	 */
	public static void main(String[] args) {
		System.out.println("LinkedList:");
		test(new LinkedList<String>(),new Gen());
		System.out.println("\nPriorityQueue:");
		test(new PriorityQueue<String>(),new Gen());
		System.out.println("\nArrayBlockingQueue:");
		test(new ArrayBlockingQueue<String>(count),new Gen());
		
		System.out.println("\nConcurrentLinkedDeque:");
//jdk7		test(new ConcurrentLinkedDeque<String>(),new Gen());
		
		System.out.println("\nLinkedBlockingQueue:");
		test(new LinkedBlockingQueue<String>(),new Gen());
		
		System.out.println("\nPriorityBlockingQueue:");
		test(new PriorityBlockingQueue<String>(),new Gen());
	}
}
