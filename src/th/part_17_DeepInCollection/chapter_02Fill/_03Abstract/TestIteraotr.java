package th.part_17_DeepInCollection.chapter_02Fill._03Abstract;

import java.util.AbstractSet;
import java.util.Iterator;


public class TestIteraotr<E> implements Iterator<E> {

	@Override
	public boolean hasNext() {
		System.out.println("hasNext");
		return false;
	}

	@Override
	public E next() {
		System.out.println("next");
		return null;
	}

	@Override
	public void remove() {
		System.out.println("remove");
	}
	public static class EntrySet<E> extends AbstractSet<E>{

		@Override
		public Iterator<E> iterator() {
			return new TestIteraotr<E>();
		}

		@Override
		public int size() {
			return 0;
		}
		
	}
	public static void main(String[] args) {
		new EntrySet<String>().iterator();
	}
}
