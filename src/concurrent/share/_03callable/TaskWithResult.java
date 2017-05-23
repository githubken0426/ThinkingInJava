package concurrent.share._03callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 使用Future
 * 
 * @author ken
 * @param <V>
 * 2017-3-21 下午02:32:01
 */
public class TaskWithResult<V> implements Callable<V> {
	
	private int id;
	public TaskWithResult(int id) {
		this.id = id;
	}

	// 和run()方法区别是：call方法可以抛出异常
	@SuppressWarnings("unchecked")
	@Override
	public V call() throws Exception {
		return (V) (Thread.currentThread() + ":" + id);
	}
	
	static void futureList(ExecutorService exe){
		try {
			List<Future<?>> list = new ArrayList<Future<?>>();
			for (int i = 0; i < 5; i++) {
				list.add(exe.submit(new TaskWithResult<String>(i)));
			}
			TimeUnit.SECONDS.sleep(2);// 可以执行其他的任务
			for (Future<?> fs : list) {
				System.out.println(fs.get());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}finally{
			exe.shutdown();
		}
	}

	/**
	 * submit()方法产生Future对象
	 * 
	 * 假设有一个很耗时的返回值需要计算，并且这个返回值不是立刻需要的话，
	 * 那么就可以用一个线程去计算返回值，而当前线程在使用这个返回值之前可以做其它的操作，
	 * 等到需要这个返回值时，再通过Future得到.
	 * @param exe
	 * 2017-3-21 下午02:34:04
	 */
	public static void main(String[] args) {
		ExecutorService exe = Executors.newCachedThreadPool();
		futureList(exe);
	}
}
