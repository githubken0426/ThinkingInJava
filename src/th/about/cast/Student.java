package th.about.cast;

public class Student {
	private int age;
	private String name;
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
	
	public String get(int i,String str){
		return i+str;
	}
	
	public String get(String str,int i){
		return str+i;
	}
}
