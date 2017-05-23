package th.part_15_Generic.chapter_09_Bounds.more;

public class SuperHero<POWER extends SuperPower> {
	POWER power;
	SuperHero(POWER power){
		this.power=power;
	}
	public POWER getPower() {
		return power;
	}
}
