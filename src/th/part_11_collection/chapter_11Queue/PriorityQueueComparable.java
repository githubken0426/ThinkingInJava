package th.part_11_collection.chapter_11Queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueComparable implements Comparable<PriorityQueueComparable> {
	private int age;
	private String name;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PriorityQueueComparable(int age,String name){
		this.age=age;
		this.name=name;
	}
	
	@Override
	public int compareTo(PriorityQueueComparable o) {
		int temp=this.age-o.getAge();
		int val=this.name.compareTo(o.getName());
		return temp==0 ? val:temp;
	}
	
	public String toString(){
		return "age:"+age+" name:"+name;
	}
	
	public static void main(String[] args) {
		PriorityQueue<PriorityQueueComparable> queue=new PriorityQueue<PriorityQueueComparable>();
		List<PriorityQueueComparable> list=new ArrayList<PriorityQueueComparable>(Arrays.asList(
				new PriorityQueueComparable(23,"afg"),new PriorityQueueComparable(43,"bbg"),
				new PriorityQueueComparable(15,"gio"),new PriorityQueueComparable(24,"liou")
		));
		Collections.sort(list);
		queue.addAll(list);
		System.out.println(queue);
	}
}
