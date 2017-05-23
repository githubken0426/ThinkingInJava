package th.part_19_ENUM.chapter_08_EnumSet;

import java.util.EnumSet;

/**
 * 19.8 Enumset
 * 
 * @author Administrator 
 * 2015-12-11 上午11:15:08
 */
public class EnumsetClass {
	public static void main(String[] args) {
		EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);
		/**
		 * public static <E extends Enum<E>> EnumSet<E> noneOf(Class<E> elementType) {
	        Enum[] universe = getUniverse(elementType);
	        if (universe == null)
	            throw new ClassCastException(elementType + " not an enum");
	        if (universe.length <= 64)
	            return new RegularEnumSet<E>(elementType, universe);
	        else
	            return new JumboEnumSet<E>(elementType, universe);
	    	}
	     *
	     * noneOf()源码：RegularEnumSet和JumboEnumSet均实现了
	     * AbstractCollection的add方法
		 */
		points.add(AlarmPoints.BATHROOM);
		System.out.println(points);
		
		// of()方法：参数1,2,3,4,5或E...重载，添加以下枚举值
		points.addAll(EnumSet.of(AlarmPoints.STAIRI, AlarmPoints.STAIR2,
				AlarmPoints.KITCHEN));
		System.out.println(points);
		// allOf()方法，添加所有枚举值，removeAll()移出包含的枚举值
		points = EnumSet.allOf(AlarmPoints.class);
		points.removeAll(EnumSet.of(AlarmPoints.STAIRI, AlarmPoints.STAIR2,
				AlarmPoints.KITCHEN));
		System.out.println(points);
	}
}
