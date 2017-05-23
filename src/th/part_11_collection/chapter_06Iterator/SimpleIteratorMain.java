package th.part_11_collection.chapter_06Iterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/**
 * 11.6 迭代器
 * 
 * @author ken
 * 2016-12-23 上午11:01:25
 */
public class SimpleIteratorMain {
	public static void main(String[] args) {
		List<PetsA> list=new ArrayList<PetsA>();
		PetsA [] pet=new PetsA[]{
				new PetsA(1,"老大",8),
				new PetsA(2,"老二",5),
				new PetsA(3,"老三",4)
		};
		//addAll第二个参数，传递的是对象或对象数组
		Collections.addAll(list,pet);
		Iterator<PetsA> iter=list.iterator();
		while(iter.hasNext()){
			PetsA p=(PetsA) iter.next();
			System.out.println(p.getName());
		}
		System.out.println();
		for (PetsA pets : pet) {
			System.out.println(pets.getName());
		}
		System.out.println();
		iter=list.iterator();
		for(int i=list.size();i>0;i--){
			iter.next();
			iter.remove();
		}
		System.out.println(list.size());
		
	}
}
