package th.part_17_DeepInCollection.chapter_02Fill._02MapGenerator;

import TIJ4_code.net.mindview.util.CountingGenerator;
import TIJ4_code.net.mindview.util.RandomGenerator;

public class MapDataMain {
	public static void main(String[] args) {
		System.out.println(MapData.map(new CountingGenerator.Character(), new RandomGenerator.String(3),8));
		
//		System.out.println(MapData.map(new CountingGenerator.Character(), "Value",6));
//		
//		System.out.println(MapData.map(new Letters(), new RandomGenerator.String(3)));
//		
//		System.out.println(MapData.map(new Letters(),"pop"));
	}
}
