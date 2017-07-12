package designPattern.headfirst.chapter_07Adapter.advanced;

public interface Iterator<E> {
	public boolean hasNext();
	public E next();
	public void remove();
}
