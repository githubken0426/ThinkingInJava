package com.compare.comparable;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;
import java.util.TreeSet;

public class PersonComparable implements Comparable<PersonComparable> {
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

	public PersonComparable(int age, String name) {
		this.age = age;
		this.name = name;
	}

	/**
	 * �Ƚϵ�ǰʵ����������� o ��
	 * ���λ�ڶ��� o ֮ǰ�����ظ�ֵ��
	 * �������������������λ����ͬ���򷵻� 0 ��
	 * ���λ�ڶ��� o ���棬�򷵻���ֵ
	 */
	@Override
	public int compareTo(PersonComparable o) {
//		int temp = age - o.getAge();
//		return temp == 0 ? ten : temp;
		System.out.println("name:"+name+",o.getName:"+o.getName());
		//�˴��ǵ���String���compareTo����
		int ten = name.compareTo(o.getName());
		System.out.println(ten);
		return ten;
	}

	public String toString() {
		return "{" + age + "--" + name + "}";
	}

	/**
	 * ʹ��Arrays�������������ʹ��Collections�Խ�Ͽ����������������ArraysList,LinkedList��
	 * @param args
	 */
	public static void main(String[] args) {
		
		PersonComparable[] person = { new PersonComparable(20, "Tom"),
				new PersonComparable(20, "Jeff"),
				new PersonComparable(30, "Mary"),
				new PersonComparable(20, "Ada"),
				new PersonComparable(40, "Walton"),
				new PersonComparable(61, "Peter"),
				new PersonComparable(20, "Bush") };
		System.out.println("����ǰ��"+Arrays.toString(person));
		Arrays.sort(person);
//		Collections.sort(list);
		System.out.println("�����"+Arrays.toString(person));

		System.out.println("TreeSet:");
		TreeSet<PersonComparable> set = new TreeSet<PersonComparable>();
		set.add(new PersonComparable(20, "Tom"));
		set.add(new PersonComparable(20, "Jeff"));
		set.add(new PersonComparable(30, "Mary"));
		set.add(new PersonComparable(20, "Ada"));
		set.add(new PersonComparable(40, "Walton"));
		set.add(new PersonComparable(61, "Peter"));
		set.add(new PersonComparable(20, "Bush"));
		System.out.println(set);
		System.out.println("TreeMap:");
		TreeMap<PersonComparable, String> map = new TreeMap<PersonComparable, String>();
		map.put(new PersonComparable(20, "Tom"), "Tom");
		map.put(new PersonComparable(20, "Jeff"), "Jeff");
		map.put(new PersonComparable(30, "Mary"), "Mary");
		map.put(new PersonComparable(20, "Ada"), "Ada");
		map.put(new PersonComparable(40, "Walton"), "Walton");
		map.put(new PersonComparable(61, "Peter"), "Peter");
		map.put(new PersonComparable(20, "Bush"), "Bush");
		System.out.println(map);
	}
}
