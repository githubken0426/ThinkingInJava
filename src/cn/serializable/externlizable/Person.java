package cn.serializable.externlizable;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class Person implements Externalizable {
	private int id;
	private String name;
	private int age;
	/**
	 * 如果定义了构造函数，必须定义无参构造函数
	 * 否则会有个异常：
	 * java.io.InvalidClassException:  no valid constructor
	 * @param id
	 * @param name
	 * @param age
	 */
	public Person(int id,String name,int age){
		this.id=id;
		this.name=name;
		this.age=age;
	}
	public Person(){}
	
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		System.out.println("开始读取！");
		this.name=(String) in.readObject();
		this.id=(Integer) in.readObject();
		this.age=(Integer) in.readObject();
		String test=(String) in.readObject();
		System.out.println(test);
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("开始序列化写入！");
		out.writeObject(name);
		out.writeObject(id);
		out.writeObject(age);
		out.writeObject("test");
		
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String path="C:\\Users\\Administrator\\Desktop\\external.txt";
		Person p=new Person(1,"李四",23);
		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(path));
		out.writeObject(p);
		
		FileInputStream file=new FileInputStream(path);
		ObjectInputStream in=new ObjectInputStream(file);
		Person person=(Person) in.readObject();
		
		System.out.println(person.getId());
		System.out.println(person.getName());
		System.out.println(person.getAge());
	}
}
