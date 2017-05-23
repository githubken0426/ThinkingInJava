package importNew.unkownAboutJava_10;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.Random;

/**
 * 关于Java你可能不知道的10件事
 * @author Administrator
 * 2016-3-4 上午09:18:25
 *
 */
public class UnknowAbout10 {
	/**
	 * 三元表达式
	 * @param args
	 */
	public static void expression(){
		Object obj1=true ? new Integer(1):new Double(2.0);
		Object obj2;
		if(true)
			obj2=new Integer(1);
		else
			obj2=new Double(2.0);
		System.out.println("obj1="+obj1);
		System.out.println("obj2="+obj2);
		
		Integer i=new Integer(1);
		if(i.equals(1))
			i=null;
		Double d=new Double(2.0);
		//NullPonterException
		Object obj3=true ? i:d;
		System.out.println("obj3="+obj3);
	}
	/**
	 * checked Exception
	 * @param args
	 */
	public static void aboutCheckedException(Exception e){
		UnknowAbout10.<RuntimeException>doThorw(e);
		
	}
	@SuppressWarnings("unchecked")
	static <E extends Exception> void doThorw(Exception e) throws E{
		throw (E)e;
	}
	
	/**
	 * 关于二维数组
	 * @param args
	 */
	public static class AbountArrays{
		int a()[][]{
			return new int[0][];
		}
		int []b()[]{
			return new int[0][];
		}
		void test(){
			int[][] a = {{}};
		    int[] b[] = {{}};
		    int c[][] = {{}};
		}
		
	}
	public static void crazy(){
		@Crazy int [][] a1={{}};
		@Crazy int []a2[]= {{}};
	}
	
	/**
	 * 随机Integer
	 * @param args
	 * @throws Exception 
	 */
	
	public static void randonInteger() throws Exception{
		// Extract the IntegerCache through reflection
	    Class<?> clazz = Class.forName(
	      "java.lang.Integer$IntegerCache");
	    Field field = clazz.getDeclaredField("cache");
	    field.setAccessible(true);
	    Integer[] cache = (Integer[]) field.get(clazz);

	    // Rewrite the Integer cache
	    for (int i = 0; i < cache.length; i++) {
	      cache[i] = new Integer(
	        new Random().nextInt(cache.length));
	    }

	    // Prove randomness
		
	}
	public static void main(String[] args) throws Exception {
//		expression();
//		aboutCheckedException(new SQLException());
		randonInteger();
		for(int i=0;i<10;i++)
			System.out.println((Integer)i);
	}
}
