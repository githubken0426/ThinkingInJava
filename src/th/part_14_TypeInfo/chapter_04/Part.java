package th.part_14_TypeInfo.chapter_04;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Part {
	
	public String toString(){
		return this.getClass().getSimpleName();
	}
	static List<Factory<? extends Part>> partFactories=new ArrayList<Factory<? extends Part>>();
	
	static{
		partFactories.add(new FuelFilter.Factory_FuelFilter());
		partFactories.add(new AirFilter.Factory_AirFilterr());
		partFactories.add(new GenertorBelt.Factory_GenertorBelt());
		partFactories.add(new FanlBelt.Factory_FanlBelt());
	}
	
	private static Random random=new Random(47);
	
	public static Part createRandom(){
		int n=random.nextInt(partFactories.size());
		return partFactories.get(n).create();
	}
	
	
}
