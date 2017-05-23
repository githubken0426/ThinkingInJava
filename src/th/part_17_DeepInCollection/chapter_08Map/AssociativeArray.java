package th.part_17_DeepInCollection.chapter_08Map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class AssociativeArray<K, V> {
	private Object[][] pairs;
	private int index;
	
	public AssociativeArray(int length){
		pairs=new Object[length][3];
	}
	
	public void put(K key,V value){
		if(index >= pairs.length)
			throw new ArrayIndexOutOfBoundsException();
		pairs[index++]=new Object[]{key,value,0};
	}
	
	@SuppressWarnings("unchecked")
	public V get(K key){
		for(int i=0;i<pairs.length;i++){
			if(key.equals(pairs[i][0]))
				return (V) pairs[i][1];
		}
		return null;
	}
	
	public String toString(){
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<index;i++){
			sb.append(pairs[i][0]);
			sb.append(":");
			sb.append(pairs[i][1]);
			if(i<index-1)
				sb.append("\n");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Map<String,String> table=new Hashtable<String,String>();
		System.out.println("table.hashCode():"+table.hashCode());
		Map<String,String> map=new HashMap<String,String>();
		System.out.println("map.hashCode():"+map.hashCode());
		AssociativeArray<String,String> associative=new AssociativeArray<String,String>(3);
		associative.put("1", "blue");
		associative.put("2", "red");
		associative.put("3", "green");
		System.out.println(associative);
		System.out.println(associative.get(null));
		associative.put("4", "gray");
	}
}
