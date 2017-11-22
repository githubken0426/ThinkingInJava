package cn.serializable.externlizable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import cn.serializable.transientDemo2.Students;

public class ExternalMain {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String path="C:\\Users\\Administrator\\Desktop\\external.txt";
		Users user=new Users();
		user.setId(10);
		user.setName("test");
		user.setPassword("admin");
		Students stu=new Students();
		stu.setName("student");
		user.setStudent(stu);
		ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream(path));
		output.writeObject(user);
		output.close();
		
		ObjectInputStream input=null;
		try {
			input=new ObjectInputStream(new FileInputStream(path)); 
			Users u=(Users) input.readObject();
			System.out.println(u);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			input.close();
		}
	}

}
