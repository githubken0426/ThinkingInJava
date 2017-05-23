package th.part_11_collection.chapter_04;

import java.util.*;
/**
 * 11.4
 * �����Ĵ�ӡ
 * 
 * @author ken
 * 2016-12-23 ����09:41:45
 */
public class PrintContiners {
	static Collection<String> fill(Collection<String> collection){
		collection.add("First");
		collection.add("Second");
		collection.add("Third");
		return collection;
	}
	static Map<Object, String> fill(Map<Object,String> map){
		map.put("First", "Fuzzy");
		map.put("Second","Rags");
		map.put("Third", "Bosco");
		map.put("Third", "Spot");
		return map;
	}
	public static void main(String[] args) {
		System.out.println("ArrayList:"+fill(new ArrayList<String>()));
		System.out.println("LinkedList:"+fill(new LinkedList<String>()));
		System.out.println("HashSet:"+fill(new HashSet<String>()));
		System.out.println("TreeSet:"+fill(new TreeSet<String>()));
		System.out.println("LinkedHashSet:"+fill(new LinkedHashSet<String>()));
		System.out.println();
		//HashMapȡ�����ݵ�˳������ȫ�����
		System.out.println("HashMap:"+fill(new HashMap<Object,String>()));
		//TreeMapʵ��SortMap�ӿڣ��ܹ���������ļ�¼���ݼ�����,Ĭ���ǰ���ֵ����������
		System.out.println("TreeMap:"+fill(new TreeMap<Object,String>()));
		//LinkedHashMap�����˼�¼�Ĳ���˳��
		System.out.println("LinkedHashMap:"+fill(new LinkedHashMap<Object,String>()));
	}
}
