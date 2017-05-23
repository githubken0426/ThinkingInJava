package th.part_21_Concurrence.chapter_02._04Callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class TaskWithResult<V> implements Callable<V> {
	private int id;
	public TaskWithResult(int id){
		this.id=id;
	}
	
	//��run()���������ǣ�call���������׳��쳣
	@SuppressWarnings("unchecked")
	@Override
	public V call() throws Exception {
		return (V) (Thread.currentThread()+":"+id);
	}

	/**
	 * submit()��������Future����,���첽����
	 * 
	 * ������һ���ܺ�ʱ�ķ���ֵ��Ҫ���㣬�����������ֵ����������Ҫ�Ļ���
	 * ��ô�Ϳ�����һ���߳�ȥ���㷵��ֵ������ǰ�߳���ʹ���������ֵ֮ǰ�����������Ĳ�����
	 * �ȵ���Ҫ�������ֵʱ����ͨ��Future�õ�.
	 * 
	 * @param args
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService exe=Executors.newCachedThreadPool();
		List<Future<String>> list=new ArrayList<Future<String>>();
		List<Future<?>> list2=new ArrayList<Future<?>>();
		for(int i=0;i<5;i++){
			//submit����Ҳ����Ϊrunnable���ͣ������䷵��ֵһֱΪnull
			Future<?> fl=exe.submit(new Runnable(){
				@Override
				public void run() {
					System.out.println(Thread.currentThread()+"-"+this.getClass().getName());
				}
			});
			list2.add(fl);
			list.add(exe.submit(new TaskWithResult<String>(i)));
		}
		exe.shutdown();
		for(Future<String> fs:list){
			if(fs.isDone())
				System.out.println(fs.get());
			TimeUnit.SECONDS.sleep(2);
		}
		
		for(Future<?> fs:list2){
			System.out.println("����ֵ��"+fs.get());
		}
	}
}
