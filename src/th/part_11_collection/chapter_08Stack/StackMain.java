package th.part_11_collection.chapter_08Stack;

public class StackMain {

	public static void main(String[] args) {
		Stack<String> stack=new Stack<String>();
		for(String s:"test,the,is,this".split(",")){
			stack.push(s);
		}
		System.out.println(stack);
		while(!stack.empty()){
			System.out.print(stack.pop()+"\n");
		}
		java.util.Stack<String> s=new java.util.Stack<String>();
		//String.CASE_INSENSITIVE_ORDER;
		for(String str:"test,the,is,this".split(",")){
			s.push(str);
		}
		System.out.println(s);
	}

}
