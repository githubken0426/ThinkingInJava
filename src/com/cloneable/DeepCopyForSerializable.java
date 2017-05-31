package com.cloneable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.Serializable;

/**
 * ���л�ʵ�����copy Ҳ����ʹ�����л��������л��ܺ�ʱ����һЩ����У�
 * ���Ǳ���Ը��ܵ�������������������д��л�����д��ݣ���ʱ�϶ࡣ
 * 
 * @author ken 2017-5-31 ����11:49:27
 */
class StudentD implements Serializable {

	private static final long serialVersionUID = 1L;
	String name;
	int age;

	StudentD(String name, int age) {
		this.name = name;
		this.age = age;
	}

}

class TeacherD implements Serializable {
	private static final long serialVersionUID = 1L;
	String name;
	int age;
	StudentD student;

	TeacherD(String name, int age, StudentD student) {
		this.name = name;
		this.age = age;
		this.student = student;
	}

	public Object deepClone() throws IOException, OptionalDataException,
			ClassNotFoundException {
		// ������д������
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		ObjectOutputStream oo = new ObjectOutputStream(bo);
		oo.writeObject(this);
		// �����������
		ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
		ObjectInputStream oi = new ObjectInputStream(bi);
		return (oi.readObject());
	}
}

public class DeepCopyForSerializable {
	public static void main(String[] args) {
		StudentD student =new StudentD("С��",10);
		TeacherD t=new TeacherD("����ʦ",30,student);
		try {
			TeacherD t2 =(TeacherD) t.deepClone();
			t2.student.age=21;
			t2.student.name="test";
			
			t2.age=32;
			t2.name="����ʦ";
			
			System.out.println("ѧ������:"+t.student.name+"������"+t.student.age);
		}catch(Exception e){
			for (StackTraceElement ele : e.getStackTrace()) {
				System.out.println(ele);
			}
		}
	}
}
