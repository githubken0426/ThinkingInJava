package th.part_11_collection.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


import th.part_14_TypeInfo.chapter_03._01.Rodent.Hamster;
import th.part_14_TypeInfo.chapter_03._01.Rodent.Mouse;
import th.part_14_TypeInfo.chapter_03._01.Rodent.Rodent;

public class E_10RodentIterator {
	public static void main(String[] args) {
		ArrayList<Rodent> list=new ArrayList<Rodent>(Arrays.asList(new Rodent(),new Mouse(),new Hamster()));
		for(Iterator<Rodent> it=list.iterator();it.hasNext();){
			Rodent r =it.next();
			r.test();
		}
	}
}
