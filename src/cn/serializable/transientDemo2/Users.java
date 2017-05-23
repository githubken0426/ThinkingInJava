package cn.serializable.transientDemo2;

import java.io.Serializable;

public class Users implements Serializable{
	/**
	 * private static final long serialVersionUID = 1L;
	 * �汾��Ϣһ�����ļ��Ŀ�ͷ������������Ϊ��������ڴ����ļ�֮ǰ���ȼ���ļ��İ汾��
	 * ����ȷ�����ļ��İ汾�����򲻱ض�ȡ�ļ������ಿ��.
	 * serialVersionUID ����������Ĳ�ͬ�汾��ļ����ԡ�
	 * ���������ɷ�ʽ�� 
	 * һ����Ĭ�ϵ�1L��
	 * ��һ���Ǹ����������ӿ�������Ա���������Ե�������һ��64λ�Ĺ�ϣ�ֶ�
	 * ��������JDK��binĿ¼�µ�serialver.exe���߲������serialVersionUID ��ֵ������Users.class��
	 * ִ�����serialver Users����ʱJVM��java�������������һ����ϣ�ֶΣ��͵ڶ��ַ�����һ����
	 * ���û��serialVersionUID�����������Ա䶯(���������)ʱ���ٴζ�ȡ���л��ĵ���
	 * ���ᱨ��:java.io.InvalidClassException
	 * 
	 * ���л����ַ�ʽ:ֻ��ʵ����Serializable��Externalizable�ӿڵ���Ķ�����ܱ����л���
	 * Externalizable�ӿڼ̳���Serializable�ӿڣ�ʵ��Externalizable�ӿڵ�����ȫ���������������л�����Ϊ��
	 * ����ʵ��Serializable�ӿڵ�����Բ���Ĭ�ϵ����л���ʽ 
	 * 
	 * ���л�����ֻ��������������Ϣ�����Ե�������Ϣ������ֵ���ͷ���û��ʲô��ϵ
	 * 
	 */
	private static final long serialVersionUID = 3915486627490640161L;
	private int id;
	/**
	 * һ����̬���������Ƿ�transient���Σ������ܱ����л���
	 * �����л�������static�ͱ�����ֵΪ��ǰJVM�ж�Ӧstatic������ֵ�����ֵ��JVM�еĲ��Ƿ����л�����.
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
