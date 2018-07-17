package cn.serializable.transientDemo2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TransientDemoMain {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Students stu = new Students();
		stu.setAge(25);
		stu.setName("student 张三");
		Users user = new Users();
		user.setId(1);
		user.setUserName("张总");
		user.setPassword("123465");
		user.setStudent(stu);

		System.out.println("序列化前姓名：" + user.getUserName());
		System.out.println("序列化前密码：" + user.getPassword());

		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("E:/user.txt"));
		os.writeObject(user);
		os.flush();
		os.close();

		Users.setUserName("我是李总：静态变量更改后的值");// 改变静态变量的值
		ObjectInputStream is = new ObjectInputStream(new FileInputStream("E:/user.txt"));
		Users user2 = (Users) is.readObject(); // 从流中读取User的数据
		is.close();
		System.out.println("\nread after Serializable: ");
		System.out.println("username: " + user2.getUserName());
		System.err.println("password: " + user2.getPassword());
		System.out.println("序列化后的studnet对象:"+user2.getStudent().getName());
	}
}
