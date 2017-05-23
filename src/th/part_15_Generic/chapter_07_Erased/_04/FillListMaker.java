package th.part_15_Generic.chapter_07_Erased._04;

import java.util.ArrayList;
import java.util.List;

public class FillListMaker<T> {
	List<T> maker(T t,int n){
		List<T> result=new ArrayList<T>();
		for(int i=0;i<n;i++)
			result.add(t);
		return result;
	}
	
	public static void main(String[] args) {
		List<String> list=new FillListMaker<String>().maker("hello", 4);
		System.out.println(list);
	}
}
