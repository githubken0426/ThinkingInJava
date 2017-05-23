package th.part_11_collection.chapter_08Stack;

import java.util.LinkedList;

/**
 * 栈， LIFO 后进先出
 * 		FILO 先进后出
 * @author Administrator
 * 2016-4-14 上午11:08:18
 * @param <T>
 *
 */
public class Stack<T> {
	private LinkedList<T> storage=new LinkedList<T>();
	
	public void push(T t){
//		storage.addFirst(t);
		storage.addLast(t);
	}
	
	public T peek(){
		return storage.getLast();
	}
	
	public T pop(){
//		return storage.removeFirst();
		return storage.removeLast();
	}
	
	public boolean empty(){
		return storage.isEmpty();
	}
	
	public String toString(){
		return storage.toString();
	}
}
