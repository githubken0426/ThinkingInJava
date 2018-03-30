package jvm.stack;

/**
 * 链表栈(1.存储结构)
 * @author Administrator
 * 2016-9-27 11:14:55
 *
 */
public class LinkedStack<T> {
	
	private static class Node<U>{
		 U item;
		 Node<U> next;
		 Node(){
			item=null;next=null;
		}
		 Node(U item,Node<U> next){
			this.item=item;
			this.next=next;
		}
		boolean end(){
			return item==null&& next==null;
		}
	}
	
	Node<T> top=new Node<T>();
	
	public void push(T item){
		top=new  Node<T>(item,top);
	}
	
	public T pop(){
		T result=top.item;
		while(!top.end()){
			top=top.next;
		}
		return result;
	}
}
