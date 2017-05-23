package resourceCode.list;

import java.util.ArrayList;
import java.util.List;

import resourceCode.list.arrayList.MyArrayList;
import resourceCode.util.ListMe;


/**
 * listÔ´Âë²âÊÔ
 * @author Administrator
 *
 * 2016-9-9 ÏÂÎç04:06:07
 */
public class MyListMain {
	public static void main(String[] args) {
		List<String> li=new ArrayList<String>();
		ListMe<String> list=new MyArrayList<String>();
		list.add(String.valueOf(Integer.MAX_VALUE));
		for(int i=0;i<=12;i++){
			list.add("a"+i);
		}
//		System.out.println(list.size());
//		System.out.println(list.isEmpty());
//		System.out.println(list.contains("a10"));
		
		System.out.println(list.indexOf("a1"));
		System.out.println(list.lastIndexOf("a1"));
		
		MyArrayList<String> arrayList=new MyArrayList<String>();
		for(int i=0;i<=12;i++){
			arrayList.add("a"+i);
		}
		arrayList.trimToSize();
	}
}
