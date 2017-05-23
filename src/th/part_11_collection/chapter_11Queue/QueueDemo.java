package th.part_11_collection.chapter_11Queue;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class QueueDemo {
	/**
	 * FIFO 先进先出
	 * 队列是一种数据结构．以一种先进先出的方式管理数据，
	 * 它有两个基本操作：在队列尾部加入一个元素，和从队列头部移除一个元素
	 * 如果你试图向一个已经满了的阻塞队列中添加一个元素或者是从一个空的阻塞队列中移除一个元索，
	 * 将导致线程阻塞,在多线程进行合作时，阻塞队列是很有用的工具。
	 * 工作者线程可以定期地把中间结果存到阻塞队列中而其他工作者线线程把中间结果取出并在将来修改它们。
	 * 队列会自动平衡负载。如果第一个线程集运行得比第二个慢，则第二个线程集在等待结果时就会阻塞。
	 * 如果第一个线程集运行得快，那么它将等待第二个线程集赶上来。
	 * 下表显示了jdk1.5中的阻塞队列的操作：

		add  	 增加一个元索，如果队列已满，则抛出一个IIIegaISlabEepeplian异常
		put      添加一个元素,如果队列满，则阻塞
		offer    添加一个元素到队尾并返回true,如果队列已满，则返回false
		
		element  返回队列头部的元素,如果队列为空，则抛出一个NoSuchElementException异常
		peek     返回队列头部的元素,如果队列为空，则返回null
		
		remove   移除并返回队列头部的元素,如果队列为空，则抛出一个NoSuchElementException异常
		poll     移除队列头部的元素并返回,如果队列为空，则返回null
		take     移除并返回队列头部的元素,如果队列为空，则阻塞
		
		注意：阻塞为BlockingQueue中方法。
		BlockingQueue接口的四种实现：
		LinkedBlockingQueue ArrayBlockingQueue PriorityBlockingQueue DelayQueue
		
		Queue使用时要尽量避免Collection的add()和remove()方法，而是要使用offer()来加入元素，
		使用poll()来获取并移出元素。它们的优点是通过返回值可以判断成功与否，
		add()和remove()方法在失败的时候会抛出异常。 
		如果要使用前端而不移出该元素，使用element()或者peek()方法
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
//			blockQueue.take();//线程阻塞
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		/**
		 * offer()返回boolean值判，断添加是否成功
		 */
		Queue<Integer> queue=new LinkedList<Integer>();
		Random random=new Random(47);
		for(int i=0;i<10;i++){
			queue.offer(random.nextInt(i+10));
		}
		if(queue.offer(123)){
			System.out.println("offer()添加成功");
		}
		System.out.println(queue);
		print(queue);
		System.out.println(queue.poll());
		System.out.println(queue);
	}
}
