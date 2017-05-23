package th.part_11_collection.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class E_11CollectionIterator {
	public static Collection<String> fill(Collection<String> collection){
		for(int i=0;i<5;i++){
			collection.add(i+"tdt");
		}
		return collection;
	}
	public static void myIterator(Iterator<String> it){
		while(it.hasNext())
			System.out.println(it.next().toString());
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		List<Collection<String>> ca=Arrays.<Collection<String>>asList
			(new ArrayList<String>(),new LinkedList<String>(),new HashSet<String>(),new TreeSet<String>());
		for(Collection<String> collection : ca)
			fill(collection);
		for (Collection<String> collection : ca) {
			myIterator(collection.iterator());
		}
	}
}
