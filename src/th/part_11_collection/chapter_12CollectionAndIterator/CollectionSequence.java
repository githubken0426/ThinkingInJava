package th.part_11_collection.chapter_12CollectionAndIterator;

import java.util.AbstractCollection;
import java.util.Iterator;

import th.part_11_collection.chapter_06Iterator.PetsA;

/**
 * 如果创建一个Collection的实现，就必须实现其所有方法(包含一些不必要的方法)，
 * 而抽象类AbstractCollection可以解决这个问题
 * (一种设计思路：通过抽象类实现接口，在继承抽象类，则必须要实现接口所有方法)
 * @author Administrator
 * 2016-4-19 上午11:23:06
 *
 */
public class CollectionSequence extends AbstractCollection<PetsA> {
	PetsA [] pets=new PetsA[]{
			new PetsA(1,"老0",8),
			new PetsA(2,"老1",5),
			new PetsA(3,"老2",4)
	};
	@Override
	public int size() {
		return pets.length;
	}
	@Override
	public Iterator<PetsA> iterator() {
		return new Iterator<PetsA>(){
			private int index=0;
			
			@Override
			public boolean hasNext(){
				return index<pets.length;
			}

			@Override
			public PetsA next() {
				return pets[index++];
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
	public static void main(String[] args) {
		CollectionSequence collectionSequence=new CollectionSequence();
		CollectionsVsIterator.display(collectionSequence);
		CollectionsVsIterator.display(collectionSequence.iterator());
		//抛出异常
		collectionSequence.iterator().remove();
	}
}
