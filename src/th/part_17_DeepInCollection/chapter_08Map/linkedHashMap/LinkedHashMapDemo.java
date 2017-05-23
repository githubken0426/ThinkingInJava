package th.part_17_DeepInCollection.chapter_08Map.linkedHashMap;

import java.util.LinkedHashMap;

import th.part_17_DeepInCollection.chapter_02Fill._03Abstract.CountingMapData;

/**
 * 17.8.3 LinkedHashMap
 * 
 * @author ken 2017-1-12 下午04:23:39
 */
public class LinkedHashMapDemo {

	public static void main(String[] args) {
		LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<Integer, String>(
				new CountingMapData(9));
		System.out.println(linkedMap);
		/**
		 * initialCapacity初始大小 loadFactor增长因子 accessOrder是否使用lru
		 */
		linkedMap = new LinkedHashMap<Integer, String>(16, 0.75f, true);
		linkedMap.putAll(new CountingMapData(9));
		System.out.println(linkedMap);
		/**
		 * LRU是Least Recently Used 近期最少使用算法 近期访问过前六个元素，元素后移，后面三个元素则移动到队列前面
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
			// super(initialCapacity, loadFactor);//这里调用父类HashMap的构造方法；
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
			int capacity = 1; // 默认是1
			while (capacity < initialCapacity)// 不断翻倍直到大于人为设置的大小
				capacity <<= 1;//左移，capacity = capacity<<1 capacity等于capacity乘以2的1次方

			this.loadFactor = loadFactor;
			//如果需要增大长度，按照capacity*loadFactor取整后增长；
			 threshold = (int)(capacity * loadFactor);
			// table = new Entry[capacity];
			// init();
		}
	}
}
