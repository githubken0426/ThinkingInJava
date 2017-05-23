package th.part_19_ENUM.chapter_07_UseImp;

import th.part_19_ENUM.chapter_06_Random.Enums;

/**
 * 枚举中的枚举1
 * @author Administrator
 * 2015-12-9 上午11:57:10
 *
 */
public enum Course {
	APPETIZER(Food.MainCourse.class),
	COFFEE(Food.Coffee.class);
	
	private Food[] values;
	private Course(Class<? extends Food> kind){
		values=kind.getEnumConstants();
	}
	public Food randonSelection(){
		return Enums.random(values);
	}
}
