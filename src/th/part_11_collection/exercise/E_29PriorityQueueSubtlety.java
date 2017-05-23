package th.part_11_collection.exercise;

import java.util.PriorityQueue;

/**
 * A priority queue relying on natural ordering
 * also does not permit insertion of non-comparable objects
 * (doing so may result in ClassCastException)
 * @author Administrator
 * 2016-4-14 ����04:10:30
 *
 */
public class E_29PriorityQueueSubtlety {
	static class Dummy{}
	/**
	 * �ڶ�����ӻᴥ���쳣
	 * @param args
	 */
	public static void main(String[] args) {
		PriorityQueue<Dummy> queue=new PriorityQueue<Dummy>();
		queue.offer(new Dummy());
		queue.offer(new Dummy());
	}
}
