package th.part_11_collection.chapter_11Queue;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class QueueDemo {
	/**
	 * FIFO �Ƚ��ȳ�
	 * ������һ�����ݽṹ����һ���Ƚ��ȳ��ķ�ʽ�������ݣ�
	 * �������������������ڶ���β������һ��Ԫ�أ��ʹӶ���ͷ���Ƴ�һ��Ԫ��
	 * �������ͼ��һ���Ѿ����˵��������������һ��Ԫ�ػ����Ǵ�һ���յ������������Ƴ�һ��Ԫ����
	 * �������߳�����,�ڶ��߳̽��к���ʱ�����������Ǻ����õĹ��ߡ�
	 * �������߳̿��Զ��ڵذ��м����浽���������ж��������������̰߳��м���ȡ�����ڽ����޸����ǡ�
	 * ���л��Զ�ƽ�⸺�ء������һ���̼߳����еñȵڶ���������ڶ����̼߳��ڵȴ����ʱ�ͻ�������
	 * �����һ���̼߳����еÿ죬��ô�����ȴ��ڶ����̼߳���������
	 * �±���ʾ��jdk1.5�е��������еĲ�����

		add  	 ����һ��Ԫ��������������������׳�һ��IIIegaISlabEepeplian�쳣
		put      ���һ��Ԫ��,�����������������
		offer    ���һ��Ԫ�ص���β������true,��������������򷵻�false
		
		element  ���ض���ͷ����Ԫ��,�������Ϊ�գ����׳�һ��NoSuchElementException�쳣
		peek     ���ض���ͷ����Ԫ��,�������Ϊ�գ��򷵻�null
		
		remove   �Ƴ������ض���ͷ����Ԫ��,�������Ϊ�գ����׳�һ��NoSuchElementException�쳣
		poll     �Ƴ�����ͷ����Ԫ�ز�����,�������Ϊ�գ��򷵻�null
		take     �Ƴ������ض���ͷ����Ԫ��,�������Ϊ�գ�������
		
		ע�⣺����ΪBlockingQueue�з�����
		BlockingQueue�ӿڵ�����ʵ�֣�
		LinkedBlockingQueue ArrayBlockingQueue PriorityBlockingQueue DelayQueue
		
		Queueʹ��ʱҪ��������Collection��add()��remove()����������Ҫʹ��offer()������Ԫ�أ�
		ʹ��poll()����ȡ���Ƴ�Ԫ�ء����ǵ��ŵ���ͨ������ֵ�����жϳɹ����
		add()��remove()������ʧ�ܵ�ʱ����׳��쳣�� 
		���Ҫʹ��ǰ�˶����Ƴ���Ԫ�أ�ʹ��element()����peek()����
	 * @param <T>
	 * @param queue
	 */
	public static <T> void print(Queue<T> queue){
		while(queue.peek()!=null){
			System.out.print(queue.remove()+",");
		}
		System.out.println();
	}
	public <T> T[] toArray(T[] a) {
		return a;
	}
	public static void main(String[] args) {
//		try {
//			BlockingQueue<File> blockQueue = new ArrayBlockingQueue<File>(10); 
//			blockQueue.take();//�߳�����
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		/**
		 * offer()����booleanֵ�У�������Ƿ�ɹ�
		 */
		Queue<Integer> queue=new LinkedList<Integer>();
		Random random=new Random(47);
		for(int i=0;i<10;i++){
			queue.offer(random.nextInt(i+10));
		}
		if(queue.offer(123)){
			System.out.println("offer()��ӳɹ�");
		}
		System.out.println(queue);
		print(queue);
		System.out.println(queue.poll());
		System.out.println(queue);
	}
}
