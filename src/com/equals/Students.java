package com.equals;

public class Students {
	private int age;
	private String name;
	
	public Students(){}
	
	public Students(int age,String name){
		super();
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
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj){
			return true;
		}
		if(obj==null){
			return false;
		}
		if(getClass()!=this.getClass()){
			return false;
		}
		Students stu=(Students) obj;
		if(stu.age!=age){
			return false;
		}
		if(null==name){
			if(stu.name!=null){
				return false;
			}
		}else if(!name.equals(stu.name)){
			return false;
		}
			return true;
	}
}
