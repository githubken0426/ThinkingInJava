package resourceCode.test.arrayList;

import java.util.Arrays;
import java.util.Collection;

import resourceCode.util.ArrayListMe;
import resourceCode.util.CollectionMe;
import resourceCode.util.ListMe;


/**
 * listÔ´Âë²âÊÔ
 * @author Administrator
 *
 * 2016-9-9 ÏÂÎç04:06:07
 */
public class ListMeTest {
	public static void main(String[] args) {
		ArrayListMe<String> arrayList=new ArrayListMe<String>();
		for(int i=0;i<11;i++){
			arrayList.add(String.valueOf(i));
		}
		arrayList.add(10," element");
		
		CollectionMe<String> cl=new ArrayListMe<String>(Arrays.asList("e","f","g")); 
		arrayList.addAll(cl);
//		arrayList.addAll(2,cl);
//		arrayList.trimToSize();
		System.out.println(arrayList.toString());
	}
}
