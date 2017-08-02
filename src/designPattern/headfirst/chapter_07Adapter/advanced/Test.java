package designPattern.headfirst.chapter_07Adapter.advanced;

import designPattern.headfirst.chapter_07Adapter.advanced.adapter.IteratorAdapter;

public class Test {
	public static void main(String[] args) {
		Iterator<String> it = new IteratorAdapter<String>(new Enumeration<String>() {
			@Override
			public boolean hasMoreElement() {
				System.out.println("Enumeration hasMoreElement!");
				return false;
			}

			@Override
			public String nextElement() {
				System.out.println("Enumeration nextElement!");
				return null;
			}
		});
		it.hasNext();
		it.next();
	}
}
