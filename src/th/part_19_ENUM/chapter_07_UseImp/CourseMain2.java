package th.part_19_ENUM.chapter_07_UseImp;

import th.part_19_ENUM.chapter_06_Random.Enums;

/**
 * ��FoodӦ�����ַ�ʽ
 * @author Administrator
 * 2015-12-9 ����02:31:20
 *
 */
public enum CourseMain2 {
	APPETZER(Food.Appeltizer.class),
	MAINCOURSE(Food.MainCourse.class),
	DESSERT(Food.Dessert.class),
	COFFEE(Food.Coffee.class);
	
	private Food[] values;
	private CourseMain2(Class<? extends Food> kind){
		values=kind.getEnumConstants();
	}
	
	public interface Food{
		enum Appeltizer implements Food{
			SALAD,SOUP,SPRING_ROLLS//����;
		}
		enum MainCourse implements Food{
			LASAGNE,BRRITO,PAD_THAT,LENTILS,HUMMOUS,VINDALOO;
		}
		enum Dessert implements Food{
			TIRAMISU,GELATO,BLACK_FOREST_CAKE,FRUIT,CREME_CARAMEL;
		}
		enum Coffee implements Food{
			BLACK_COFFEE,DECAF_COFFEE,EXPRESSO,LATTE,CAPPUCCINO,HERB_TEA;
		}
	}
	
	public Food randomSelection(){
		return Enums.random(values);
	}
	
	/**
	 * ����ö�ٵ�values()�����󣬻�ȡö�ٵ�ֵ����ִ�й��캯��
	 * ������Ϊ�Լ�������ö�٣�����SALAD��SALAD2(SALAD, 0)(SALAD2, 1)��
	 * Ҳ����˵��Ĭ��ִ��Enum��Ĺ��캯��(String name, int ordinal)
	 * �Լ�������ö�ٹ�����������Enum��Ĺ���
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i=0;i<5;i++){
			for(CourseMain2 course:CourseMain2.values()){
				Food food=course.randomSelection();
				System.out.println(food);
			}
			System.out.println("********************");
		}
	}
}
