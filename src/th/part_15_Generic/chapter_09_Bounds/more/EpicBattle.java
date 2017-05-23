package th.part_15_Generic.chapter_09_Bounds.more;

import java.util.List;

public class EpicBattle {
	//bounds in generic methods
	static <POWER extends SuperHearing> void userSuperHearing(SuperHero<POWER> hero){
		hero.getPower().hearSubtleNoises();
	}
	
	static <POWER extends SuperHearing & SuperSmell> void superFind(SuperHero<POWER> hero){
		hero.getPower().hearSubtleNoises();
		hero.getPower().hearSubtleNoises();
	}
	
	public static void main(String[] args) {
		DogBoy dogBoy=new DogBoy();
		userSuperHearing(dogBoy);
		superFind(dogBoy);
		List<? extends SuperHearing> audioBoy;
		//?通配符被限制单一边界
//		List<? extends SuperHearing & SuperSmell> dogBoys;
	}
}
