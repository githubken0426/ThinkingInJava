package th.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import th.part_14_TypeInfo.chapter_03._01.Pet;
import th.part_14_TypeInfo.chapter_08_NullObject._01.Person;

public class NewGeneric {
	public static <K,V> Map<K,V> map(){
		return new HashMap<K,V>();
	}
	
	public static <K> List<K> list(){
		return new ArrayList<K>();
	}
	
	public static <K> LinkedList<K> linkedList(){
		return new LinkedList<K>();
	}
	
	public static <K> Queue<K> queue(){
		return new LinkedList<K>();
	}
	
	public static <K> Set<K> set(){
		return new HashSet<K>();
	}
	
	public static void main(String[] args) {
		Map<String,List<String>> map=NewGeneric.map();
		Map<Person,List<? extends Pet>> person=NewGeneric.map();
	}
}
