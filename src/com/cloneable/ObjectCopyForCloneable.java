package com.cloneable;

class Students implements Cloneable{
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
 
    Teacher(String name, int age,Students student) {
        this.name = name;
        this.age = age;
        this.student=student;
    }

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Teacher t=null;
		t=(Teacher) super.clone();
		/**
		 * �˴��������clone()����student��ָ��ͬһ������
		 * (��ȡTeacher��clone����󣬶�Teacher.student.age�ֶθ��ģ�
		 * student���ᷢ���仯��Ҳ����shallow copy)
		 */
//		t.student=(Students) student.clone();
		return t;
	}
    
}

public class ObjectCopyForCloneable {
	public static void main(String[] args) {
		Students student =new Students("С��",10);
		Teacher t=new Teacher("����ʦ",30,student);
		try {
			Teacher t2 =(Teacher) t.clone();
			t2.student.age=21;
			t2.student.name="test";
			
			t2.age=32;
			t2.name="����ʦ";
			
			System.out.println("ѧ������:"+t.student.name+"������"+t.student.age);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}
