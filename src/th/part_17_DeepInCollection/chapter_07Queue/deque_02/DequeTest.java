package th.part_17_DeepInCollection.chapter_07Queue.deque_02;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
//import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class DequeTest {
	static void fill(MyDeque<Integer> deque){
		for(int i=0;i<10;i++)
			deque.addFirst(i);
		for(int i=10;i<20;i++)
			deque.addLast(i);
		
	}
	/**
	 * ArrayDeque, ConcurrentLinkedDeque, LinkedBlockingDeque, LinkedList
	 */
	public static void main(String[] args) {
		MyDeque<Integer> deque=new MyDeque<Integer>();
		fill(deque);
		System.out.println(deque);
		Deque<Object> de=new LinkedList<Object>();
		Deque<Object> de2=new ArrayDeque<Object>();
//jdk7		Deque<Object> de3=new ConcurrentLinkedDeque<Object>();
		Deque<Object> de4=new LinkedBlockingDeque<Object>();
	}
}
