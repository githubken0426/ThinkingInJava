package th.part_15_Generic.chapter_04_GenericMethod._01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/**
 * 杠杆利用参数类型推断
 * 
 * @author ken
 * 2016-9-28 上午10:26:18
 */
public class New {
	public static <K,V> Map<K,V> map(){
		return new HashMap<K,V>();
	}
	
	public static <T> List<T> list(){
		return new ArrayList<T>();
	}
	
	public static <T> LinkedList<T> linkedList(){
		return new LinkedList<T>();
	}
	
	public static <T> Set<T> set(){
		return new HashSet<T>();
	}
	
	public static <T> Queue<T> queue(){
		return new LinkedList<T>();
	}
	
	public static void main(String[] args) {
		Map<String,Object> map=New.map();
		List<String> list=New.list();
		LinkedList<Integer> linkedList=New.linkedList();
		Set<Double> set=New.set();
		Queue<New> queue=New.queue();
	}
}
