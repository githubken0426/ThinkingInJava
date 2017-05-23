package th.part_11_collection.exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class E_18MapOrder {
	public static void main(String[] args) {
		Map<Object,String> map=new HashMap<Object,String>();
		map.put("SYT", "WER");
		map.put("ABN","OOP");
		map.put("BGF","WAR");
		System.out.println(map);
		Map<Object,String> linkedMap=new LinkedHashMap<Object,String>();
		
		String keys[]=map.keySet().toArray(new String[0]);
//		Object keys2[]=map.keySet().toArray();
		Arrays.sort(keys);
		
		for(Object key:keys){
			linkedMap.put(key, map.get(key));
		}
		System.out.println(linkedMap);
	}
}
