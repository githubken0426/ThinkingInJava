package th.part_11_collection.exercise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class E_08gerbilIterator {
	public static void main(String[] args) {
		List<Gerbil> list=new ArrayList<Gerbil>();
		for(int i=0;i<10;i++){
			list.add(new Gerbil(i));
		}
		
		for(Iterator<Gerbil> it=list.iterator();it.hasNext();it.next().hop());
	}
}
