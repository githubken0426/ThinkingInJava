package th.part_14_TypeInfo.chapter_03._01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import th.part_14_TypeInfo.chapter_03._01.Cats.Cat;
import th.part_14_TypeInfo.chapter_03._01.Cats.EgyptianMauCat;
import th.part_14_TypeInfo.chapter_03._01.Cats.Manx;
import th.part_14_TypeInfo.chapter_03._01.Dog.Dog;
import th.part_14_TypeInfo.chapter_03._01.Dog.MuttDog;
import th.part_14_TypeInfo.chapter_03._01.Rodent.Gerbil;
import th.part_14_TypeInfo.chapter_03._01.Rodent.Hamster;
import th.part_14_TypeInfo.chapter_03._01.Rodent.Mouse;
import th.part_14_TypeInfo.chapter_03._01.Rodent.Rat;
import th.part_14_TypeInfo.chapter_03._01.Rodent.Rodent;

public class PetCount  {
	
	static class PetCounter extends HashMap<String,Integer>{
		public void count(String type){
			Integer quantity=get(type);
			if(quantity==null){
				put(type,1);
			}else{
				put(type,quantity+1);
			}
		}
	}
	
	public static void countPets(PetCreator petCreator){
		PetCounter counter=new PetCounter();
		for(Pet pet:petCreator.createArray(20)){
			System.out.println(pet.getClass().getSimpleName()+" ");
			if(pet instanceof Pet){
				counter.count("Pets");
			}
			if(pet instanceof Dog){
				counter.count("Dog");
			}
			if(pet instanceof MuttDog){
				counter.count("MuttDog");
			}
			if(pet instanceof Cat){
				counter.count("Cat");
			}
			if(pet instanceof EgyptianMauCat){
				counter.count("EgyptianMauCat");
			}
			if(pet instanceof Manx){
				counter.count("Manx");
			}
			if(pet instanceof Rodent){
				counter.count("Rodent");
			}
			if(pet instanceof Rat){
				counter.count("Rat");
			}
			if(pet instanceof Mouse){
				counter.count("Mouse");
			}
			if(pet instanceof Hamster){
				counter.count("Hamster");
			}
			if(pet instanceof Gerbil){
				counter.count("Gerbil");
			}
		}
		System.out.println(counter);
	}
	
	public static void main(String[] args) {
		countPets(new ForNameCreator());
		Collection<String> c = new ArrayList<String>();  
        Collection<String> s = Collections.unmodifiableCollection(c);  
        c.add("str");  
//        s.add("s");
        /**
         * unmodifiableCollection()方法可以得到一个集合的镜像，它的返回结果不可直接被改变
         * s.add("b");
         * 对s的改变会出现异常:
         * java.lang.UnsupportedOperationException
         */
        System.out.println(s); 
	}
}
