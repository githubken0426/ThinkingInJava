package th.part_15_Generic.chapter_09_Bounds.more;

public class CanierHero<POWER extends SuperHearing & SuperSmell> extends SuperHero<POWER> {

	CanierHero(POWER power) {
		super(power);
	}
	void hear(){
		power.hearSubtleNoises();
	}
	void smell(){
		power.trackBySmell();
	}
}
