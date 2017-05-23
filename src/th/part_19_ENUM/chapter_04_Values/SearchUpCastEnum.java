package th.part_19_ENUM.chapter_04_Values;

/**
 * getEnumConstants()是Class上的方法，不是枚举也可以使用此方法
 * @author Administrator
 * 2015-12-9 上午08:48:02
 *
 */
public class SearchUpCastEnum {
	public static void main(String[] args) {
		Search[] values =Search.values();
		Enum<Search> e=Search.HITHER;//up cast
//		e.values();//compile error 没有此方法
		for(Enum<Search> en :e.getClass().getEnumConstants()){
			System.out.println(en);
		}
		
		Class<Integer> intClass=Integer.class;
		for(Object obj:intClass.getEnumConstants()){//返回结果null，NullPointerException
			System.out.println("obj:"+obj);
		}
	}
}
