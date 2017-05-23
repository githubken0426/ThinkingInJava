package th.part_17_DeepInCollection.chapter_08Map.linkedHashMap;

import java.util.LinkedHashMap;

import th.part_17_DeepInCollection.chapter_02Fill._03Abstract.CountingMapData;

/**
 * 17.8.3 LinkedHashMap
 * 
 * @author ken 2017-1-12 ����04:23:39
 */
public class LinkedHashMapDemo {

	public static void main(String[] args) {
		LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<Integer, String>(
				new CountingMapData(9));
		System.out.println(linkedMap);
		/**
		 * initialCapacity��ʼ��С loadFactor�������� accessOrder�Ƿ�ʹ��lru
		 */
		linkedMap = new LinkedHashMap<Integer, String>(16, 0.75f, true);
		linkedMap.putAll(new CountingMapData(9));
		System.out.println(linkedMap);
		/**
		 * LRU��Least Recently Used ��������ʹ���㷨 ���ڷ��ʹ�ǰ����Ԫ�أ�Ԫ�غ��ƣ���������Ԫ�����ƶ�������ǰ��
		 */
		for (int i = 0; i < 6; i++)
			linkedMap.get(i);
		System.out.println(linkedMap);
		linkedMap.get(0);
		System.out.println(linkedMap);

	}

	class TestResourceMap {
		private Integer MAXIMUM_CAPACITY = 1000;
		private float loadFactor=0.1f;
		private int threshold;

		public TestResourceMap(int initialCapacity, float loadFactor,
				boolean accessOrder) {
			// super(initialCapacity, loadFactor);//������ø���HashMap�Ĺ��췽����
			// this.accessOrder = accessOrder;
		}

		public TestResourceMap(int initialCapacity, float loadFactor) {
			if (initialCapacity < 0)
				throw new IllegalArgumentException("Illegal initial capacity: "
						+ initialCapacity);
			if (initialCapacity > MAXIMUM_CAPACITY)
				initialCapacity = MAXIMUM_CAPACITY;
			if (loadFactor <= 0 || Float.isNaN(loadFactor))
				throw new IllegalArgumentException("Illegal load factor: "
						+ loadFactor);
			// Find a power of 2 >= initialCapacity
			int capacity = 1; // Ĭ����1
			while (capacity < initialCapacity)// ���Ϸ���ֱ��������Ϊ���õĴ�С
				capacity <<= 1;//���ƣ�capacity = capacity<<1 capacity����capacity����2��1�η�

			this.loadFactor = loadFactor;
			//�����Ҫ���󳤶ȣ�����capacity*loadFactorȡ����������
			 threshold = (int)(capacity * loadFactor);
			// table = new Entry[capacity];
			// init();
		}
	}
}
