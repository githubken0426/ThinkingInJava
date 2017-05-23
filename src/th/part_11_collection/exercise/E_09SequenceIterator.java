package th.part_11_collection.exercise;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class E_09SequenceIterator {
	static class Sequence{
		private Object[] items;
		private int next;
		
		public Sequence(int size){
			items=new Object[size];
		}
		
		public void add(Object obj){
			if(next<items.length)
				items[next++]=obj;
		}
		
		class SequenceIterator implements Iterator<Object>{
			private int i;
		
			@Override
			public boolean hasNext() {
				return i<items.length;
			}

			@Override
			public Object next() {
				if(hasNext())
					return items[i++];
				throw new NoSuchElementException();
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		}
		
		public Iterator<Object> iterator(){
			return new SequenceIterator();
		}
	}
	
	public static void main(String[] args) {
		Sequence seq=new Sequence(10);
		for(int i=0;i<10;i++)
			seq.add(Integer.toString(i));
		Iterator<?> it=seq.iterator();
		while(it.hasNext())
			System.out.println(it.next());
//		for(Iterator<?> it=seq.iterator();it.hasNext();)
//			System.out.println(it.next());
	}
}
