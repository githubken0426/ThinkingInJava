package importNew.finalpool;

public class IntegerAndInt {
	public static void main(String[] args) {
		// testNumber(129);
//		testNumber();
		int i=IntegerResourceCode.valueOf(100);
		System.out.println(i);
		Character c=129;
		Character c2=c;
		System.out.println(c==c2);//true���˴��Ƕ��������
		Character c3=128;
		Character c4=128;
		System.out.println(c3==c4);//false���ο�������
		Byte b1= -128;
		Byte b2=-128;
		System.out.println(b1==b2);

	}

	public static void testNumber(int number) {
		System.out.println(number);
		int i = number;
		// �Զ�װ�䣬Integer i2=Integer.valueOf(127);
		Integer i2 = number;
		Integer i3 = new Integer(number);
		// ture ,�ڽ��бȽ�ʱ��i2���Զ�����Ϊint
		System.out.println(i == i2);
		// ture ,�ڽ��бȽ�ʱ��i3���Զ�����Ϊint
		System.out.println(i == i3);
		// false ,��������Ƚϣ�һ�������ڳ����أ�һ�������ڶ��С�
		System.out.println(i2 == i3);
	}

	/**
	 * ������127ʱ,���в�ͬ�Ľ��
	 * 
	 * 2017-4-1 ����01:26:12
	 */
	public static void testNumber() {
		Integer i2 = -128;
		Integer o = -128;
		// ture ,127�����ڳ������У���ͬһ��ֵ
		System.out.println("-128<number<127֮��������������ڳ�������:" + (i2 == o));

		Integer n2 = -129;
		Integer m = -129;
		// false ,128�����ڳ������У�n2��m����ͬ�Ķ�����ֵ�ֱ�洢�ڶ��в�ͬλ�á�
		System.out.println("-128<number<127֮������������ڳ�������,����ͬ�Ķ���:" + (n2 == m));
	}

	/**
	 * Դ�����
	 * 
	 * @author ken 2017-4-1 ����01:25:53
	 */
	static class IntegerResourceCode {
		/**
		 * A cache of instances used by {@link Integer#valueOf(int)} and
		 * auto-boxing
		 */
		private static final Integer[] SMALL_VALUES = new Integer[256];
		static {
			for (int i = -128; i < 128; i++) {
				SMALL_VALUES[i + 128] = new Integer(i);
			}
		}

		public static Integer valueOf(int i) {
			assert IntegerCache.high >= 127;
			Integer cache[]=IntegerCache.cache;
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
				// ԴString integerCacheHighPropValue
				// =sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
				if (integerCacheHighPropValue != null) {
					// Դint i = parseInt(integerCacheHighPropValue);
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
			private IntegerCache() {}
		}
	}
}
