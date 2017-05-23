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
