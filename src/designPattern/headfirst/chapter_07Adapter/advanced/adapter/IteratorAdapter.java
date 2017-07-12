package designPattern.headfirst.chapter_07Adapter.advanced.adapter;

import designPattern.headfirst.chapter_07Adapter.advanced.Enumeration;
import designPattern.headfirst.chapter_07Adapter.advanced.Iterator;

public class IteratorAdapter<E> implements Iterator<E> {
	Enumeration<E> enumeration;
	public IteratorAdapter(Enumeration<E> enumeration){
		this.enumeration=enumeration;
	}
	
	@Override
	public boolean hasNext() {
		return enumeration.hasMoreElement();
	}

	@Override
	public E next() {
		return enumeration.nextElement();
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
