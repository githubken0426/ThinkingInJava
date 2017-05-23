package th.part_21_Concurrence.chapter_02._14Exception.other;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ExecutorService��submit()��execute()��������
 * submit()�з���ֵ������Callable<T>,Runnable,T�Ȳ���,ͨ����Futureһ��ʹ��
 * execute()û�з���ֵ��ֻ����Runnable
 * @author Administrator
 *
 */

public class WorkThreadFactory {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService exe=Executors.newCachedThreadPool(new LoggerThreadFactory());
		exe.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("�쳣��ʼ��");
				throw new RuntimeException();
			}
		});
		
		List<Future<? extends Object>> list=new ArrayList<Future<? extends Object>>();
		list.add(exe.submit(new Runnable() {
			@Override
			public void run() {
				System.out.println("Future�����쳣��");
				throw new RuntimeException();
			}
		}));
		exe.shutdown();//ִ�������Ҫ���Ϲرգ�����future�����쳣���޷��ر�
		for(Future<? extends Object> fs:list){
			System.out.println(fs.get());
		}
		
		
	}
}
