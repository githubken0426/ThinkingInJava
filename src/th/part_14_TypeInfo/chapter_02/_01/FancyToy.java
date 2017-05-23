package th.part_14_TypeInfo.chapter_02._01;

import th.part_14_TypeInfo.chapter_02._01.GetClass.HasBatteries;
import th.part_14_TypeInfo.chapter_02._01.GetClass.Shoots;
import th.part_14_TypeInfo.chapter_02._01.GetClass.Toy;
import th.part_14_TypeInfo.chapter_02._01.GetClass.Waterproof;

public class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public FancyToy(){
		super(1);
	}
}
