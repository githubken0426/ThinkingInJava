package cn.serializable.transientDemo2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TransientDemoMain {
	
	public static void main(String[] args) throws IOException,ClassNotFoundException {
		
		Students stu=new Students();
		stu.setAge(25);
		stu.setName("student ����");
		Users user = new Users();
		user.setId(1);
		Users.setUserName("����");
		user.setPassword("123465");
		user.setStudent(stu);

		System.out.println("���л�ǰ������" + Users.getUserName());
		System.out.println("���л�ǰ���룺" + user.getPassword());

		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("E:/user.txt"));
		os.writeObject(user);
		os.flush();
		os.close();

		Users.setUserName("�������ܣ���̬�������ĺ��ֵ");//�ı侲̬������ֵ
		ObjectInputStream is = new ObjectInputStream(new FileInputStream("E:/user.txt"));
		Users user2 = (Users) is.readObject(); // �����ж�ȡUser������
		is.close();
		System.out.println("\nread after Serializable: ");
		System.out.println("username: " + Users.getUserName());
		System.err.println("password: " + user2.getPassword());
		
		System.out.println(user2.getStudent().getName());
	}
}
