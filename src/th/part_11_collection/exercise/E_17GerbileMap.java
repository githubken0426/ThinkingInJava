package th.part_11_collection.exercise;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;




public class E_17GerbileMap {
	public static void main(String[] args) {
		Map<Object,Gerbil> map=new HashMap<Object,Gerbil>();
		map.put("Gerbil_1", new Gerbil(1,"Gerbil_1"));
		map.put("Gerbil_2", new Gerbil(1,"Gerbil_2"));
		
		Iterator<Object> it=map.keySet().iterator();
//		Iterator<Entry<Object, Gerbil>> it1=map.entrySet().iterator();
		
		while(it.hasNext()){
			String key= (String) it.next();
			Gerbil g=map.get(key);
			System.out.println(g);
			g.hop();
		}
	}
}
