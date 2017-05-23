package th.part_14_TypeInfo.chapter_03._02;

import java.util.LinkedHashMap;
import java.util.Map;

import th.part_14_TypeInfo.chapter_03._01.ForNameCreator;
import th.part_14_TypeInfo.chapter_03._01.LiteralPetCreator;
import th.part_14_TypeInfo.chapter_03._01.PetCreator;
import th.part_14_TypeInfo.chapter_03._01.Pet;

public class Petcount3 {
	static class Petcounter extends LinkedHashMap<Class<? extends Pet>,Integer>{
		public Petcounter(){
			//super(MapData.map(LiteralPetCreator.allTypes,0));
		}
		public void count(Pet pet){
			for(Map.Entry<Class<? extends Pet>, Integer> pair:entrySet()){
				if(pair.getKey().isInstance(pet)){
					put(pair.getKey(),pair.getValue()+1);
				}
			}
		}
		public String toString(){
			StringBuilder sb=new StringBuilder("{");
			for(Map.Entry<Class<? extends Pet>, Integer> pair:entrySet()){
				sb.append(pair.getKey().getSimpleName());
				sb.append("=");
				sb.append(pair.getValue());
				sb.append(", ");
			}
			sb.delete(sb.length()-1,sb.length());
			sb.append("}");
			return sb.toString();
		}
		
		public static void main(String[] args) throws InstantiationException, IllegalAccessException {
			Petcounter count=new Petcounter();
			for(Pet pet: ForNameCreator.class.newInstance().createArray(20)){
				System.out.println(pet.getClass().getSimpleName());
				count.count(pet);
			}
		}
	}
}
