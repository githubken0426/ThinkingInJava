package th.part_15_Generic.exercise;

/**
 * 练习5
 * 内部类也可以访问外部类型参数
 * @author Administrator
 * 2015年9月18日
 * @param <T>
 */

public class E05_LinkedStack<T> {
	private  class Node{
		T item;
		Node next;
		Node(){
			item=null;
			next=null;
		}
		
		Node(T item,Node next){
			this.item=item;
			this.next=next;
		}
		boolean end(){
			return item==null&& next==null;
		}
	}
	
	private Node top=new Node();
	
	public void push(T item){
		top=new Node(item,top);
	}
	
	public T pop(){
		T result=top.item;
		if(!top.end()){
			top=top.next;
		}
		return result;
	}
	
	public static void main(String[] args) {
		E05_LinkedStack<String> link=new E05_LinkedStack<String>();
		
		for (String str : "Phasers on stun".split(" ")) {
			link.push(str);
		}
		String s;
		while((s=link.pop())!=null){
			System.out.println(s);
		}
	}
}
