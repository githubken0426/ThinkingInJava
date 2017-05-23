package th.part_19_ENUM.chapter_07_UseImp;

import th.part_19_ENUM.chapter_07_UseImp.Food.Appeltizer;
import th.part_19_ENUM.chapter_07_UseImp.Food.MainCourse;

/**
 * 19.7 使用接口组织枚举
 * 
 * @author ken
 * 2017-5-2 上午11:37:15
 */
public class TypeOfFood {
	public static void main(String[] args) {
		Food food=Appeltizer.SPRING_ROLLS;
		food=MainCourse.LASAGNE;
		System.out.println(food);
		
		int a=010;//0开始，表示8进制
		System.out.println(a);
		int b=0x10;//0x开始，表示16进制
		System.out.println(b);
	}
}
