package th.part_20_Annotation.chapter_01_Base._04;

import th.part_20_Annotation.chapter_01_Base._03.Constraints;

public class Person {
	@EnumAnnotation(TestEnum.SQLInteger) @Constraints(primaryKey=true,unique=true) 
	private int id;
	@EnumAnnotation(TestEnum.SQLString) @Constraints(allowNull=false)
	private String name;
	@EnumAnnotation(TestEnum.SQLDouble) @Constraints()
	private double salary;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
