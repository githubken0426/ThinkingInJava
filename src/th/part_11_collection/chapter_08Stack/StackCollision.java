package th.part_11_collection.chapter_08Stack;

/**
 * 两种stack的演示
 * @author Administrator
 * 2016-4-19 上午09:15:26
 *
 */
public class StackCollision {
	public static void main(String[] args) {
		Stack<String> stack1=new Stack<String>();
		for(String str:"Dog my is This".split(" ")){
			stack1.push(str);
		}
		System.out.println("stack1:"+stack1);
		System.out.println("peek:"+stack1.peek());
		while(!stack1.empty()){
			System.out.println(stack1.pop());
		}
		java.util.Stack<String> stack2=new java.util.Stack<String>();
		for(String str:"Dog my is This".split(" ")){
			stack2.push(str);
		}
		System.out.println("stack2:"+stack2);
		//以1为基数，即栈顶为1
		System.out.println("peek:"+stack2.peek());
//		System.out.println(stack2.search("Dog"));
		while(!stack2.empty()){
			System.out.println(stack2.pop());
		}
	}
}
