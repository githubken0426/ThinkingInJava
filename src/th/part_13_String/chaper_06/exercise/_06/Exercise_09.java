package th.part_13_String.chaper_06.exercise._06;

public class Exercise_09 {
	/**
	 * (?i)ʹ���Сд��ƥ��
	 * @param args
	 */
	public static void main(String[] args) {
		String str="Hoo,you Are the greatest man";
		System.out.println(str.replaceAll("(?i)[aeiou]", "_"));
	}
}
