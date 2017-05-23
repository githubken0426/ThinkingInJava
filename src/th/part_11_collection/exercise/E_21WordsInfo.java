package th.part_11_collection.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import TIJ4_code.net.mindview.util.TextFile;


public class E_21WordsInfo {
	public static void main(String[] args) {
		Map<String,Integer> map=new HashMap<String,Integer>();
		String path="src\\th\\part_11_collection\\exercise\\E_21WordsInfo.java";
		for(String word:new TextFile(path,"\\W+")){
			Integer temp=map.get(word);
			map.put(word,temp==null?1:temp+1);
		}
		List<String> keys=new ArrayList<String>(map.keySet());
		Collections.sort(keys,String.CASE_INSENSITIVE_ORDER);
		System.out.println(map);
	}
	
}
