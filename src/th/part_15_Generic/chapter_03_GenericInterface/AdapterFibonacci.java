package th.part_15_Generic.chapter_03_GenericInterface;

import java.util.Iterator;
/**
 * 继承实现适配器
 * 
 * @author ken
 * 2016-9-28 上午09:25:42
 */
public class AdapterFibonacci extends Fibonacci implements Iterable<Integer> {
	private int count;
	Fibonacci fib=new Fibonacci();
	
	public AdapterFibonacci(int count){
		this.count=count;
	}
	
	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>(){

			@Override
			public boolean hasNext() {
				return count>0;
			}

			@Override
			public Integer next() {
				count--;
				System.out.println("AdapterFibonacci count:"+count);
				return AdapterFibonacci.this.next();
				/**
				 * 组合代替继承
				 */
//				return fib.next();
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
	
	public static void main(String[] args) {
		System.out.println("********************************");
		for(int i:new AdapterFibonacci(18)){
			System.out.print(i+" ");
		}
	}

}
