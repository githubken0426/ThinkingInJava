package th.part_19_ENUM.chapter_05_Imp;

import TIJ4_code.net.mindview.util.Generator;

public class Enumimplementation {
	public static <T> void printNext(Generator<T> tg){
		System.out.println(tg.next()+",");
	}
	
	public static void main(String[] args) {
		CartoonCharacter cc=CartoonCharacter.BOB;
		for(int i=0;i<7;i++){
			printNext(cc);
		}
	}
}
