package th.part_11_collection.exercise;

import java.util.Collection;
import java.util.Iterator;

import th.part_14_TypeInfo.chapter_03._01.Pet;
import th.part_14_TypeInfo.chapter_03._01.Pets;

public class E_30PetsCollection implements Collection<Pet> {
	protected Pet [] pets=Pets.createArray(10);
	
	@Override
	public int size() {
		return pets.length;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean contains(Object o) {
		return false;
	}

	@Override
	public Iterator<Pet> iterator() {
		return new Iterator<Pet>(){
			private int index=0;
			@Override
			public boolean hasNext() {
				return index<pets.length;
			}

			@Override
			public Pet next() {
				return null;
			}

			@Override
			public void remove() {
				
			}
			
		};
	}

	@Override
	public Object[] toArray() {
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	@Override
	public boolean add(Pet e) {
		return false;
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Pet> c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public void clear() {
		
	}

}
