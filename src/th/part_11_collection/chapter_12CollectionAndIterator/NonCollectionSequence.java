package th.part_11_collection.chapter_12CollectionAndIterator;

import java.util.Iterator;

import th.part_11_collection.chapter_06Iterator.PetsA;

/**
 * 通过CollectionSequence和PetsCollection比较：
 * 如果实现Collection就必须实现iterator()及其他方法
 * 继承AbstractCollection仅仅需要实现iterator()方法
 * 但是通过继承并创建iterator()就更方便了
 * @author Administrator
 * 2016-4-15 上午09:06:03
 *
 */
public class NonCollectionSequence extends PetsSequence{
	
	public Iterator<PetsA> iterator(){
		return new Iterator<PetsA>(){
			private int index=0;
			
			@Override
			public boolean hasNext() {
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
		NonCollectionSequence noSeq=new NonCollectionSequence();
		CollectionsVsIterator.display(noSeq.iterator());
	}
}
