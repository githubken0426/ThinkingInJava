package th.part_14_TypeInfo;

import java.lang.reflect.Array;
/**
 * 动态创建数组
 * 
 * @author ken
 * 2017-5-22 上午09:32:07
 */
public class ArrayTest {
	
	public static void main(String[] args) {
		//如果是运行时才知道类型，使用下面的方法：
//		Object array1 = Array.newInstance(componentType, length);  
		
		int array[]=(int[]) Array.newInstance(int.class, 10);
		for(int i=0;i<array.length;i++)
			System.out.print(array[i]+",");
	}
}
