package com.compare.comparator;

import java.util.Arrays;
import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
	
	@Override
	public int compare(Person o1, Person o2) {
		int temp=o1.getAge()-o2.getAge();
		int str=o1.getName().compareTo(o2.getName());
		return temp==0 ? str:temp;
	}

	public static void main(String[] args) {
		Person person[]=new Person[]{
				new Person("giu",10),new Person("alo",20),new Person("bco",23),new Person("bko",21)
		};
		Arrays.sort(person,new PersonComparator());
		for(int i=0;i<person.length;i++){
			System.out.println(person[i].toString());
		}
	}
}
