package th.part_15_Generic.chapter_03_GenericInterface;

import java.util.Iterator;
import java.util.Random;

import th.util.Generator;

public class CoffGenerator implements Generator<Coffee>, Iterable<Coffee> {

	private Class[] type = { Coffee.Latte.class, Coffee.Mocha.class,
			Coffee.Cappuccino.class };

	private static Random random = new Random(47);

	public CoffGenerator() {
	}

	private int size = 0;

	public CoffGenerator(int size) {
		this.size = size;
	}

	/**
	 * java.lang.InstantiationException ʵ�����쳣
	 * ԭ��Latte��Mocha��CappuccinoΪ�ڲ��࣬��Ҫ����static���η�
	 */
	@Override
	public Coffee next() {
		try {
			return (Coffee) type[random.nextInt(type.length)].newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	/**
	 * ͨ��CoffGenerator���вι��죬����count�Ĵ�С
	 * 
	 * @author ken
	 * 2016-9-27 ����03:54:42
	 */
	class CoffeeIterator implements Iterator<Coffee> {
		int count = size;

		@Override
		public boolean hasNext() {
			return count > 0;
		}

		@Override
		public Coffee next() {
			count--;
			return CoffGenerator.this.next();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	@Override
	public Iterator<Coffee> iterator() {
		return new CoffeeIterator();
	}

	public static void main(String[] args) {
//		CoffGenerator gen = new CoffGenerator();
//		for (int i = 0; i < 5; i++) {
//			Coffee c = gen.next();
//			System.out.println(c);
//		}

		System.out.println("**********************");
		for (Coffee c : new CoffGenerator(5)) {
			System.out.println(c);
		}
	}
}
