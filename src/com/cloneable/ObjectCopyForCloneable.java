package com.cloneable;

class Students implements Cloneable {
	String name;
	int age;

	Students(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class Teacher implements Cloneable {
	String name;
	int age;
	Students student;

	Teacher(String name, int age, Students student) {
		this.name = name;
		this.age = age;
		this.student = student;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Teacher t = null;
		t = (Teacher) super.clone();
		/**
		 * 此处如果不做clone()处理，student将指向同一个引用 (获取Teacher的clone对象后，对Teacher.student.age字段更改，
		 * student不会发生变化，也即是shallow copy)
		 */
		// t.student=(Students) student.clone();
		return t;
	}

}

public class ObjectCopyForCloneable {
	public static void main(String[] args) {
		Students student = new Students("小明", 10);
		Teacher t = new Teacher("张老师", 30, student);
		try {
			Teacher t2 = (Teacher) t.clone();
			t2.student.age = 21;
			t2.student.name = "test";

			t2.age = 32;
			t2.name = "李老师";

			System.out.println("学生名称:" + t.student.name + "，年龄" + t.student.age);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}