package th.part_14_TypeInfo.chapter_02._02;

public class GenericClassReference {
	public static void main(String[] args) {
		Class intClass=int.class;
		Class<Integer> gerericeClass=int.class;
		intClass=double.class;
		
		System.out.println(intClass);
		System.out.println(gerericeClass);
		//compile error:Integer Class对象并不是Number class对象的子类
		//Class<Number> numberClass=int.class;
	}
}
