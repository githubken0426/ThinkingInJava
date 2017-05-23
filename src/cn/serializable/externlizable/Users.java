package cn.serializable.externlizable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

import cn.serializable.transientDemo2.Students;

public class Users implements Externalizable{
	/**
	 * �汾��
	 */
	private static final long serialVersionUID = -4207483236608327184L;
	
	private int id;
	private String name;
	/**
	 * ʵ����Exeternalizble���������Ƿ�transient���Σ�
	 * ���writeExternal()���������л��˴˱������������ǻᱻ���л�
	 */
	private transient String password;
	private Students student;
	
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
	
	//�����л�����ʱ,�÷����Զ�����
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("����ִ�����л�����");   
        //���������л�ʱд������ı���   
		Date d=new Date();
        out.writeObject(d);
        out.writeObject(id);
        out.writeObject(name);
        out.writeObject(password);
        out.writeObject(student);
	}
	
	 /**
	  * �������л�����ʱ,�÷����Զ�����
	  * �����л������е����Ա�������л��е������Ⱥ�˳��һֱ
	  */
	@Override
	public void readExternal(ObjectInput in) throws IOException,ClassNotFoundException {
		 System.out.println("ִ�з����л�����");  
		 Date d=(Date)in.readObject();   
	     System.out.println(d); 
	     
	     this.id=(Integer) in.readObject();
	     this.name=(String)in.readObject();   
	     this.password=(String)in.readObject();
	     this.student=(Students) in.readObject();
	}
	
	public String toString(){   
        return "�û���: "+this.name+";ѧ��������"+this.student.getName()+",����:"+this.password; 
    }   
	
}
