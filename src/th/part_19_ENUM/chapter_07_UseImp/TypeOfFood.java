package th.part_19_ENUM.chapter_07_UseImp;

import th.part_19_ENUM.chapter_07_UseImp.Food.Appeltizer;
import th.part_19_ENUM.chapter_07_UseImp.Food.MainCourse;

/**
 * 19.7 ʹ�ýӿ���֯ö��
 * 
 * @author ken
 * 2017-5-2 ����11:37:15
 */
public class TypeOfFood {
	public static void main(String[] args) {
		Food food=Appeltizer.SPRING_ROLLS;
		food=MainCourse.LASAGNE;
		System.out.println(food);
		
		int a=010;//0��ʼ����ʾ8����
		System.out.println(a);
		int b=0x10;//0x��ʼ����ʾ16����
		System.out.println(b);
	}
}
