package th.part_19_ENUM.chapter_06_Random;

import java.util.Random;

/**
 * 19.6 随机选取
 * @author Administrator
 * 2015-12-9 上午09:59:23
 *
 */
public class Enums {
	private static Random random=new Random(47);
	
	public static <T> T random(T[] values){
		return values[random.nextInt(values.length)];
	}
	//<T extends Enum<T>>表示一个enum的实例
	public static <T extends Enum<T>> T random(Class<T> c){
		return random(c.getEnumConstants());
	}
	
	
}
