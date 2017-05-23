package th.part_19_ENUM.chapter_07_UseImp;


public class CourseMainMeal {
	public static void main(String[] args) {
		for(int i=0;i<5;i++){
			for(Course course:Course.values()){
				Food food=course.randonSelection();
				System.out.println(food);
			}
			System.out.println("*****");
		}
	}
}
