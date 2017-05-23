package designPattern.NullObject_pattern;

import java.io.Serializable;


public class NullPerson extends Person implements Serializable{
	public NullPerson(){
		super(0,"none");
	}

	public String toString(){
		return "对不起，没有此人！";
	}
	public static final Person NULL=new NullPerson();
	
}
