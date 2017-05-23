package th.part_15_Generic.chapter_03_GenericInterface;

import th.util.Generator;

public class Fibonacci implements Generator<Integer> {
	private int count;

	@Override
	public Integer next() {
		int result=fib(count++);
		return result;
	}

	private int fib(int n){
		if(n<2){
			return 1;
		} 
		return fib(n-2)+fib(n-1);
	}
	
	/**
	 * Fibonacci类中的成员变量全是int基本类型，泛型参数确是Integer类型，这说明泛型具备自动装箱拆箱
	 * 这也说明了java泛型的局限性:基本类型无法作为泛型参数
	 * @param args
	 *	2015年9月24日
	 */
	public static void main(String[] args) {
		Fibonacci fib=new Fibonacci();
		for(int i=0;i<18;i++){
			System.out.println(fib.next());
		}
	}
}
