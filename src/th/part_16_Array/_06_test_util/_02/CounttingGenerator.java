package th.part_16_Array._06_test_util._02;

import TIJ4_code.net.mindview.util.Generator;

/**
 * 使用生成器
 * @author Administrator
 * 2015-11-16 上午11:58:53
 *
 */
public class CounttingGenerator {
	public static class Boolean implements Generator<java.lang.Boolean>{
		private boolean value=false;
		@Override
		public java.lang.Boolean next() {
			value = !value;
			return value;
		}
	}
	public static class Byte implements Generator<java.lang.Byte>{
		private byte value=0;
		@Override
		public java.lang.Byte next() {
			return value++;
		}
	}
	
	static char[] ch=("ABCDEFGH").toCharArray();
	public static class Character implements Generator<java.lang.Character>{
		private int index=1;
		@Override
		public java.lang.Character next() {
			index=(index+1)%ch.length;
			return ch[index];
		}
	}
	public static int size=10;
	public static void test(Class<?> suroundClass){
		for (Class<?> t : suroundClass.getClasses()) {
			System.out.println(t.getSimpleName()+":");
			try {
				Generator<?> g=(Generator<?>) t.newInstance();
				for(int i=0;i<size;i++)
					System.out.print(g.next()+",");
				System.out.println();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		test(CounttingGenerator.class);
	}
}
