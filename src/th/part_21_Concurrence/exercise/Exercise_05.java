package th.part_21_Concurrence.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import TIJ4_code.net.mindview.util.Generator;

/**
 * 练习5
 * @author Administrator
 * 2016-1-18 下午04:42:42
 *
 */
public class Exercise_05 implements Generator<Integer>,Callable<Integer> {
	private int count;
	private final int n;
	
	public Exercise_05(int n){
		this.n =n;
	}
	
	private static int fib(int n){
		if(n<2)return 1;
		int result=fib(n-2)+fib(n-1);
		return result;
	}
	
	@Override
	public Integer next() {
		return fib(count++);
	}

	@Override
	public Integer call() throws Exception {
		int sum=0;
		for(int i=0;i<n;i++)
			sum+=next();
		return sum;
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService exe=Executors.newFixedThreadPool(4);
		List<Future<Integer>> list=new ArrayList<Future<Integer>>();
		for(int i =1;i<=5;i++)
			list.add(exe.submit(new Exercise_05(i)));
		Thread.yield();
		exe.shutdown();
		/**
		 * Future就是对于具体的Runnable或者Callable任务的执行结果进行取消、查询是否完成、获取结果。
		 * 必要时可以通过get方法获取执行结果，该方法会阻塞直到任务返回结果
		 */
		for (Future<Integer> future : list) {
			System.out.println(future.get());
		}
	}
}
