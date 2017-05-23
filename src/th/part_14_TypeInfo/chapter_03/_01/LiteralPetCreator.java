package th.part_14_TypeInfo.chapter_03._01;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import th.part_14_TypeInfo.chapter_03._01.Cats.EgyptianMauCat;
import th.part_14_TypeInfo.chapter_03._01.Cats.Manx;
import th.part_14_TypeInfo.chapter_03._01.Dog.Dog;
import th.part_14_TypeInfo.chapter_03._01.Dog.MuttDog;
import th.part_14_TypeInfo.chapter_03._01.Dog.PugDog;
import th.part_14_TypeInfo.chapter_03._01.Rodent.Hamster;
import th.part_14_TypeInfo.chapter_03._01.Rodent.Mouse;
import th.part_14_TypeInfo.chapter_03._01.Rodent.Rat;
import th.part_14_TypeInfo.chapter_03._01.Rodent.Rodent;

public class LiteralPetCreator extends PetCreator {
	/**
	 * ? extends T �˴��ļ̳���һ���Ĵ�����
	 * Pets extends Individual(����) >> Dog extends Pets >> MuttDog extends Dog
	 * ��ͨ����Ϳ��Դ���Individual Pet Dog MuttDog���������;���
	 * 
	 */
	static List<? extends Individual> l=Arrays.asList(new Individual(),new Pet(),new Dog(),new MuttDog());
	
	@SuppressWarnings("unchecked")
	public static final List<Class<? extends Pet>> allTypes=Collections.unmodifiableList(
			Arrays.asList(Pet.class,Dog.class,Rodent.class,MuttDog.class,PugDog.class,
					EgyptianMauCat.class,Manx.class,Rat.class,Mouse.class,Hamster.class));
	
	private static final List<Class<? extends Pet>>  types = 
			allTypes.subList(0,allTypes.indexOf(MuttDog.class));
	
	@Override
	public List<Class<? extends Pet>> types() {
		return types;
	}
	public static void main(String[] args) {
		ForNameCreator name=new ForNameCreator();
		Individual in=new MuttDog();
		System.out.println(in);
		System.out.println(types);
//		System.out.println(l);
	}
}
