package th.part_10_InnerClass.chapter_06._01;

import th.part_10_InnerClass.chapter_06._01.InnerInteface2.Chess;
import th.part_10_InnerClass.chapter_06._01.InnerInteface2.GameFactory;

public class Games {
	public static void palyGame(GameFactory facotry){
		while(facotry.getGame().move());
	}
	public static void main(String[] args) {
//		palyGame(Checker.factory);
		
		palyGame(new Chess().factory);
	}
}
