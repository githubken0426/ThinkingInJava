package th.part_17_DeepInCollection.chapter_09HashCode._03;
/**
 * 17.9.3
 * ����HashCode
 * 
 * @author ken
 * 2017-1-23 ����01:30:01
 */
public class StringHashCode {
	public static void main(String[] args) {
		String[] str="hello world".split(" ");
		System.out.println(str[0].hashCode());
		System.out.println(str[1].hashCode());
	}
}
