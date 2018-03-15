package designPattern.NullObject;

public class PersonMain {
	public static void main(String[] args) {
		Person person=PersonFactory.getPerson(-1,"测试");
		System.out.println(person);
	}
}
