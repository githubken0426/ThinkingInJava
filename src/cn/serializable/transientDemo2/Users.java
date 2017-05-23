package cn.serializable.transientDemo2;

import java.io.Serializable;

public class Users implements Serializable{
	/**
	 * private static final long serialVersionUID = 1L;
	 * 版本信息一般在文件的开头声明，这是因为程序必须在处理文件之前首先检查文件的版本，
	 * 除非确定了文件的版本，否则不必读取文件的其余部分.
	 * serialVersionUID 用来表明类的不同版本间的兼容性。
	 * 有两种生成方式： 
	 * 一种是默认的1L；
	 * 另一种是根据类名、接口名、成员方法及属性等来生成一个64位的哈希字段
	 * 可以利用JDK的bin目录下的serialver.exe工具产生这个serialVersionUID 的值，对于Users.class，
	 * 执行命令：serialver Users，这时JVM（java虚拟机）会生成一个哈希字段，和第二种方法是一样的
	 * 如果没有serialVersionUID，当类中属性变动(新增或减少)时候，再次读取序列化文档，
	 * 将会报错:java.io.InvalidClassException
	 * 
	 * 序列化两种方式:只有实现了Serializable或Externalizable接口的类的对象才能被序列化。
	 * Externalizable接口继承自Serializable接口，实现Externalizable接口的类完全由自身来控制序列化的行为，
	 * 而仅实现Serializable接口的类可以采用默认的序列化方式 
	 * 
	 * 序列化机制只保存对象的类型信息，属性的类型信息和属性值，和方法没有什么关系
	 * 
	 */
	private static final long serialVersionUID = 3915486627490640161L;
	private int id;
	/**
	 * 一个静态变量不管是否被transient修饰，均不能被序列化，
	 * 反序列化后类中static型变量的值为当前JVM中对应static变量的值，这个值是JVM中的不是反序列化出的.
	 */
	private static String userName;
	private transient String password;
	private Students student;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public static String getUserName() {
		return userName;
	}
	public static void setUserName(String userName) {
		Users.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Students getStudent() {
		return student;
	}
	public void setStudent(Students student) {
		this.student = student;
	}
}
