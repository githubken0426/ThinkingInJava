package th.part_15_Generic.chapter_02_SimpleGeneric._03_RandomList;

import java.util.ArrayList;
import java.util.Random;

public class RandomList<T> {
	private ArrayList<T> storage=new ArrayList<T>();
	private Random random=new Random(47);
	
	public void add(T t){
		storage.add(t);
	}
	
	public T select(){
		return storage.get(random.nextInt(storage.size()));
	}
	
	public static void main(String[] args) {
		RandomList<String> list=new RandomList<String>();
		for (String str : ("The quick brown fox jumped over "
				+ "the lazy brown dog").split(" ")) {
			list.add(str);
		}
		
		for (int i=1;i<11;i++) {
			System.out.print(list.select()+" ");
		}
	}
}
