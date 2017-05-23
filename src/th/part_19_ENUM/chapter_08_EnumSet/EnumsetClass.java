package th.part_19_ENUM.chapter_08_EnumSet;

import java.util.EnumSet;

/**
 * 19.8 Enumset
 * 
 * @author Administrator 
 * 2015-12-11 ����11:15:08
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
	     * noneOf()Դ�룺RegularEnumSet��JumboEnumSet��ʵ����
	     * AbstractCollection��add����
		 */
		points.add(AlarmPoints.BATHROOM);
		System.out.println(points);
		
		// of()����������1,2,3,4,5��E...���أ��������ö��ֵ
		points.addAll(EnumSet.of(AlarmPoints.STAIRI, AlarmPoints.STAIR2,
				AlarmPoints.KITCHEN));
		System.out.println(points);
		// allOf()�������������ö��ֵ��removeAll()�Ƴ�������ö��ֵ
		points = EnumSet.allOf(AlarmPoints.class);
		points.removeAll(EnumSet.of(AlarmPoints.STAIRI, AlarmPoints.STAIR2,
				AlarmPoints.KITCHEN));
		System.out.println(points);
	}
}
