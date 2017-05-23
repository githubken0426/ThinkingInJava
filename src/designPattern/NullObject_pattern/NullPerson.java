package designPattern.NullObject_pattern;

import java.io.Serializable;


public class NullPerson extends Person implements Serializable{
	public NullPerson(){
		super(0,"none");
	}

	public String toString(){
		return "�Բ���û�д��ˣ�";
	}
	public static final Person NULL=new NullPerson();
	
}
