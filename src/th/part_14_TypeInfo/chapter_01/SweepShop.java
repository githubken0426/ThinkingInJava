package th.part_14_TypeInfo.chapter_01;

public class SweepShop {
	/**
	 * �����õģ�����д��
	 * @param name
	 * @return
	 */
	public static Type<?> getName(String name){
		Type<String> t=new Type<String> ("name");
		return t;
	}
	
	public static void main(String[] args) {
		String path="th.part_14_TypeInfo.chapter_01.Gum";
		new Candy();
		try {
			Class.forName(path);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
