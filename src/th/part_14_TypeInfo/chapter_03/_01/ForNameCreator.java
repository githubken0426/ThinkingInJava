package th.part_14_TypeInfo.chapter_03._01;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {
	private static List<Class<? extends Pet>> types=new ArrayList<Class<? extends Pet>>();
	
	private final static String pk="th.part_14_TypeInfo.chapter_03._01."; 
	private static String [] typesName={
		pk+"Dog.MuttDog",pk+"Dog.PugDog",	pk+"Cats.EgyptianMauCat",pk+"Cats.Manx",
		pk+"Rodent.Mouse",pk+"Rodent.Rat",pk+"Rodent.Hamster",pk+"Rodent.Gerbil"
	};
	static{
		try {
			for (String name: typesName) {
				types.add((Class<? extends Pet>)Class.forName(name));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Class<? extends Pet>> types() {
		return types;
	}

}
