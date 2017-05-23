package th.part_11_collection.chapter_05List;

import java.util.Collections;
import java.util.List;
import java.util.Random;


import th.part_14_TypeInfo.chapter_03._01.Pet;
import th.part_14_TypeInfo.chapter_03._01.Pets;
import th.part_14_TypeInfo.chapter_03._01.Rodent.Hamster;
/**
 * 11.5 List
 * 
 * @author ken
 * 2016-12-23 上午10:31:13
 */
public class ListFeatures {
	public static void main(String[] args) {
		Random rand=new Random(47);
		List<Pet> list=Pets.arrayList(7);
		System.out.println(list);
		Hamster h=new Hamster();
		System.out.println("indexOf(h):"+list.indexOf(h));
		System.out.println(list.contains(h));
		System.out.println(list.remove(h));
		List<Pet> sub=list.subList(0,4);
		System.out.println(sub);
		Collections.shuffle(sub,rand);//混合在一,随机打乱顺序
		System.out.println(sub);
	}
}
