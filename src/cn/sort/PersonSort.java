package cn.sort;

import java.util.Arrays;
import java.util.Comparator;

import com.compare.comparator.Person;

public class PersonSort implements Comparator<Person> {
	
	@Override
	public int compare(Person o1, Person o2) {
		int temp=o1.getAge()-o2.getAge();
		int n=o1.getName().compareTo(o2.getName());
		return temp==0? n:temp;
	}
	
	public static void main(String[] args) {
		Person []person=new Person[]{
				new Person("lisi",14),new Person("laoli",25),new Person("asa",14),
				new Person("liqin",34),new Person("bsr",14),new Person("lili",24)
				};
		System.out.println(Arrays.asList(person));
		Arrays.sort(person,new PersonSort());
		System.out.println(Arrays.asList(person));
	}

}
