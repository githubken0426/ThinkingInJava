package importNew.finalpool;

public class IntegerAndInt {
	public static void main(String[] args) {
		// testNumber(129);
		// testNumber();
		int i = IntegerResourceCode.valueOf(100);
		System.out.println(i);
		Character c = 129;
		Character c2 = c;
		System.out.println(c == c2);// true，此处是对象的引用
		Character c3 = 128;
		Character c4 = 128;
		System.out.println(c3 == c4);// false，参考常量池
		Byte b1 = -128;
		Byte b2 = -128;
		System.out.println(b1 == b2);
	}

	public static void testNumber(int number) {
		System.out.println(number);
		int i = number;
		// 自动装箱，Integer i2=Integer.valueOf(127);
		Integer i2 = number;
		Integer i3 = new Integer(number);
		// ture ,在进行比较时，i2会自动拆箱为int
		System.out.println(i == i2);
		// ture ,在进行比较时，i3会自动拆箱为int
		System.out.println(i == i3);
		// false ,两个对象比较，一个存在于常量池，一个存在于堆中。
		System.out.println(i2 == i3);
	}

	/**
	 * 当大与127时,会有不同的结果
	 * 
	 * 2017-4-1 下午01:26:12
	 */
	public static void testNumber() {
		Integer i2 = -128;
		Integer o = -128;
		// ture ,127存在于常量池中，是同一个值
		System.out.println("-128<number<127之间的整数均存在于常量池中:" + (i2 == o));

		Integer n2 = -129;
		Integer m = -129;
		// false ,128不存在常量池中，n2和m代表不同的对象，其值分别存储在堆中不同位置。
		System.out.println("-128<number<127之外的整数不存在常量池中,代表不同的对象:" + (n2 == m));
	}

	/**
	 * 源码分析
	 * 
	 * @author ken 2017-4-1 下午01:25:53
	 */
	static class IntegerResourceCode {
		/**
		 * A cache of instances used by {@link Integer#valueOf(int)} and auto-boxing
		 */
		private static final Integer[] SMALL_VALUES = new Integer[256];
		static {
			for (int i = -128; i < 128; i++) {
				SMALL_VALUES[i + 128] = new Integer(i);
			}
		}

		public static Integer valueOf(int i) {
			assert IntegerCache.high >= 127;
			Integer cache[] = IntegerCache.cache;
			System.out.println(cache);
			if (i >= IntegerCache.low && i <= IntegerCache.high)
				return IntegerCache.cache[i + (-IntegerCache.low)];
			return new Integer(i);
		}

		private static class IntegerCache {
			static final int low = -128;
			static final int high;
			static final Integer cache[];
			static {
				// high value may be configured by property
				int h = 127;
				String integerCacheHighPropValue = "100";
				// 源String integerCacheHighPropValue
				// =sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
				if (integerCacheHighPropValue != null) {
					// 源int i = parseInt(integerCacheHighPropValue);
					int i = Integer.valueOf(integerCacheHighPropValue);
					i = Math.max(i, 127);
					// Maximum array size is Integer.MAX_VALUE
					h = Math.min(i, Integer.MAX_VALUE - (-low) - 1);
				}
				high = h;
				cache = new Integer[(high - low) + 1];
				int j = low;
				for (int k = 0; k < cache.length; k++)
					cache[k] = new Integer(j++);
			}

			private IntegerCache() {
			}
		}
	}
}
