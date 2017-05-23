package th.part_11_collection.chapter_12CollectionAndIterator;

import java.util.AbstractCollection;
import java.util.Iterator;

import th.part_11_collection.chapter_06Iterator.PetsA;

/**
 * �������һ��Collection��ʵ�֣��ͱ���ʵ�������з���(����һЩ����Ҫ�ķ���)��
 * ��������AbstractCollection���Խ���������
 * (һ�����˼·��ͨ��������ʵ�ֽӿڣ��ڼ̳г����࣬�����Ҫʵ�ֽӿ����з���)
 * @author Administrator
 * 2016-4-19 ����11:23:06
 *
 */
public class CollectionSequence extends AbstractCollection<PetsA> {
	PetsA [] pets=new PetsA[]{
			new PetsA(1,"��0",8),
			new PetsA(2,"��1",5),
			new PetsA(3,"��2",4)
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
		//�׳��쳣
		collectionSequence.iterator().remove();
	}
}
