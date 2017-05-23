package th.part_19_ENUM.chapter_07_UseImp;

import th.part_19_ENUM.chapter_06_Random.Enums;

/**
 * 将Food应用这种方式
 * @author Administrator
 * 2015-12-9 下午02:31:20
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
			SALAD,SOUP,SPRING_ROLLS//春卷;
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
	 * 调用枚举的values()方法后，获取枚举的值，会执行构造函数
	 * 这是因为自己创建的枚举，比如SALAD，SALAD2(SALAD, 0)(SALAD2, 1)，
	 * 也就是说会默认执行Enum类的构造函数(String name, int ordinal)
	 * 自己创建的枚举构造器里会调用Enum类的构造
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
