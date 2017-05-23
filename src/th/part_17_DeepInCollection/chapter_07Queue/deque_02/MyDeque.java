package th.part_17_DeepInCollection.chapter_07Queue.deque_02;

import java.util.LinkedList;

/**
 * 17.7.2
 * 双向队列
 * 
 * @author ken
 * @param <T>
 * 2017-1-6 上午09:17:48
 */
public class MyDeque<T> {
	
	LinkedList<T> linkedList=new LinkedList<T>();
	public void addFirst(T e){
		linkedList.addFirst(e);
	}
	
	public void addLast(T e){
		linkedList.addLast(e);
	}
	
	public T getFirst(){
		return linkedList.getFirst();
	}
	
	public T getLast(){
		return linkedList.getLast();
	}
	
	public void removeFirst(){
		linkedList.removeFirst();
	}
	
	public void removeLast(){
		linkedList.removeLast();
	}
	
	public int size(){
		return linkedList.size();
	}
	public String toString(){
		return linkedList.toString();
	}
}
