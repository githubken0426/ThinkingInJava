package th.part_19_ENUM.chapter_04_Values;

/**
 * getEnumConstants()��Class�ϵķ���������ö��Ҳ����ʹ�ô˷���
 * @author Administrator
 * 2015-12-9 ����08:48:02
 *
 */
public class SearchUpCastEnum {
	public static void main(String[] args) {
		Search[] values =Search.values();
		Enum<Search> e=Search.HITHER;//up cast
//		e.values();//compile error û�д˷���
		for(Enum<Search> en :e.getClass().getEnumConstants()){
			System.out.println(en);
		}
		
		Class<Integer> intClass=Integer.class;
		for(Object obj:intClass.getEnumConstants()){//���ؽ��null��NullPointerException
			System.out.println("obj:"+obj);
		}
	}
}
