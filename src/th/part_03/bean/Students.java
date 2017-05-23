package th.part_03.bean;

public class Students {
	private int age;
	private String name;
	
	public Students(){}
	
	public Students(int age,String name){
		this.age=age;
		this.name=name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
