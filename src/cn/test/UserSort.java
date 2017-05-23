package cn.test;

import java.util.Arrays;
import java.util.Collections;


public class UserSort implements Comparable<UserSort> {
	private int age;
	private String name;
	
	public UserSort(){}
	
	public UserSort(String name){
		this.name=name;
	}
	public UserSort(int age,String name){
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

	public String toString(){
		return "age:"+age+",name:"+name;
	}
	@Override
	public int compareTo(UserSort o) {
		int temp=this.age-o.getAge();
		int n=this.name.compareTo(o.getName());
		return temp==0? n:temp;
	}
	public static void main(String[] args) {
		UserSort []users=new UserSort[]{
				new UserSort(14,"lisi"),new UserSort(34,"amo"),
				new UserSort(34,"bmo"),new UserSort(14,"hisi"),new UserSort(24,"oisi")
		};
		System.out.println(Arrays.asList(users));
		Collections.sort(Arrays.asList(users));
		System.out.println(Arrays.asList(users));
	}
}
