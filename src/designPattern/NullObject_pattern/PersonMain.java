package designPattern.NullObject_pattern;

public class PersonMain {
	public static void main(String[] args) {
		Person person=PersonFactory.getPerson(-1,"����");
		System.out.println(person);
	}
}
