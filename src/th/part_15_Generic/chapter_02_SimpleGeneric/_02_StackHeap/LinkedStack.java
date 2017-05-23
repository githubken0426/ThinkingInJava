package th.part_15_Generic.chapter_02_SimpleGeneric._02_StackHeap;

/**
 * ����ʽ�洢����
 * @author Administrator
 * 2015��9��18��
 * @param <T>
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
	
	private Node<T> top=new Node<T>();
	
	public void push(T item){
		top=new Node<T>(item,top);
	}
	
	public T pop(){
		T result=top.item;
		if(!top.end()){
			top=top.next;
		}
		return result;
	}
	/**
	 * ����
	 * @param args
	 *	2015��9��23��
	 */
	public static void main(String[] args) {
		LinkedStack<String> link=new LinkedStack<String>();
		
		for (String str : "Phasers on stun".split(" ")) {
			link.push(str);
		}
		String s;
		while((s=link.pop())!=null){
			System.out.println(s);
		}
	}
}
