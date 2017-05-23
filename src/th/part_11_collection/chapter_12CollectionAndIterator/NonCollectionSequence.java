package th.part_11_collection.chapter_12CollectionAndIterator;

import java.util.Iterator;

import th.part_11_collection.chapter_06Iterator.PetsA;

/**
 * ͨ��CollectionSequence��PetsCollection�Ƚϣ�
 * ���ʵ��Collection�ͱ���ʵ��iterator()����������
 * �̳�AbstractCollection������Ҫʵ��iterator()����
 * ����ͨ���̳в�����iterator()�͸�������
 * @author Administrator
 * 2016-4-15 ����09:06:03
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
