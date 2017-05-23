package th.part_15_Generic.chapter_09_Bounds.more;

public class SuperSleuth<POWER extends XRayVision> extends SuperHero<POWER> {

	SuperSleuth(POWER power) {
		super(power);
	}
	void see(){
		power.seeThroughWalls();
	}
}
