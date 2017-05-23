package th.part_11_collection.exercise;

import th.part_11_collection.chapter_08Stack.Stack;


public class E_15Evalution {
	static Stack<Character> stack=new Stack<Character>();
	public static void evalutioin(String str){
		char [] data=str.toCharArray();
		for(int i=0;i<data.length;i++){
			switch(data[i++]){
			case '+':
				stack.push(data[i]);
				break;
			case '-':
				System.out.print(stack.pop());
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		evalutioin("+U+n+c---+e+r+t---+a-+i-+n+t+y---+ -+r+u--+l+e+s---");
	}
}
