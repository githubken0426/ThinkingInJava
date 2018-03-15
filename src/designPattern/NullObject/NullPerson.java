package designPattern.NullObject;

import java.io.Serializable;


public class NullPerson extends Person implements Serializable{
	private static final long serialVersionUID = 1L;
	public NullPerson(){
		super(0,"none");
	}

	public String toString(){
		return "空对象";
	}
	public static final Person NULL=new NullPerson();
	
}
