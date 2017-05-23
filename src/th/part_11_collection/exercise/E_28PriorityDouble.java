package th.part_11_collection.exercise;

import java.util.PriorityQueue;
import java.util.Random;

public class E_28PriorityDouble {

	public static void main(String[] args) {
		Random random=new Random(47);
		PriorityQueue<Double> queue=new PriorityQueue<Double>();
		for(int i=0;i<10;i++){
			queue.offer(random.nextDouble());
		}
		System.out.println(queue);
		while(queue.peek()!=null)
			System.out.print(queue.remove()+",");
	}
}
