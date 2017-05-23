package th.part_14_TypeInfo.chapter_03._01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class PetCreator {
	private Random rand=new Random(47);
	
	public abstract List<Class<? extends Pet>> types();
	
	public  Pet randomPet(){
		int n=rand.nextInt(types().size());
		try {
			return types().get(n).newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException();
		} catch (IllegalAccessException e) {
			throw new RuntimeException();
		}
	}
	
	public  Pet[] createArray(int size){
		Pet[] pet=new Pet[size];
		for(int i=0;i<size;i++)
			pet[i]=randomPet();
		return pet;
	}
	
	public ArrayList<Pet> arrayList(int size){
		ArrayList<Pet> array=new ArrayList<Pet>();
		Collections.addAll(array, createArray(size));
		return array;
	}
}
