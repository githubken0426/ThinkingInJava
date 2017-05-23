package th.part_11_collection.chapter_13ForeachAndIterator.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import th.part_11_collection.chapter_06Iterator.PetsA;
import th.part_11_collection.chapter_12CollectionAndIterator.CollectionsVsIterator;

public class ReversibleArrayList<T> extends ArrayList<T> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1797737526518823348L;

	public ReversibleArrayList(Collection<T> c){
		super(c);
	}
	
	public Iterable<T> reversed(){
		return new Iterable<T>(){
			@Override
			public Iterator<T> iterator() {
				return new Iterator<T>(){
					int current=size()-1;
					@Override
					public boolean hasNext() {
						return current>-1;
					}
					@Override
					public T next() {
						return get(current--);
					}
					@Override
					public void remove() {
						throw new UnsupportedOperationException();
					}
				};
			}
		};
	}
	
	public static void main(String[] args) {
		ReversibleArrayList<String> rever=new ReversibleArrayList<String>
			(Arrays.asList("To be or not be".split("")));
		for (String s : rever) {
			System.out.print(s+"");
		}
		System.out.println();
		for(String s : rever.reversed()){
			System.out.print(s+"");
		}
		System.out.println();
		ReversibleArrayList<PetsA> reverPets=new ReversibleArrayList<PetsA>
			(Arrays.asList(new PetsA("json"),new PetsA("json2")));
		CollectionsVsIterator.display(reverPets);
	}
}
