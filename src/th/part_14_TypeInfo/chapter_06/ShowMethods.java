package th.part_14_TypeInfo.chapter_06;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;
/**
 * 
 * @author Administrator
 * 2015��9��11��
 */
public class ShowMethods {
	private static String usage="usage:\n"+"To show all methods in class or:\n"
			+ "ShowMthods qualified.class.name word\n"
			+ "To search for methods involving 'word'";
	private static Pattern p=Pattern.compile("\\w+\\.|native\\s|final\\s");
	
	/**
	 * �������η�ȱʡʱ��getConstructors()����ȡ�������캯��
	 * @param args
	 *	2015��9��11��
	 */
	public static void main(String[] args) {
		if(args.length< 1){
			System.out.println(usage);
			System.exit(0);
		}
		String path="th.part_14_TypeInfo.chapter_06.ShowMethods.class";
		int lines =0;
		try {
			Class<?> c=Class.forName(args[0]);
			Method [] methods=c.getMethods();
			Method [] myMethods=c.getDeclaredMethods();
			Constructor[] con=c.getConstructors();
			if(args.length==1){
				for (Method method : methods) {
					System.out.println(p.matcher(method.toString()).replaceAll(""));
				}
				for (Method method : myMethods) {
					System.out.println("���Լ��ķ���:"+p.matcher(method.toString()).replaceAll(""));
				}
				for (Constructor constructor : con) {
					System.out.println("���캯��:"+p.matcher(constructor.toString()).replaceAll(""));
				}
				lines=methods.length+con.length;
			}else{
				for (Method method : methods) {
					if(method.toString().indexOf(args[0])!=-1){
						System.out.println(p.matcher(method.toString()).replaceAll(""));
					}
					lines++;
				}
				for (Constructor constructor : con) {
					if(constructor.toString().indexOf(args[0])!=-1){
						System.out.println(p.matcher(constructor.toString()).replaceAll(""));
					}
					lines++;
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
