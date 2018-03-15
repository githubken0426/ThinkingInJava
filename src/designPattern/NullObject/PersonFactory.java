package designPattern.NullObject;

public class PersonFactory {
	
	public static Person getPerson(int id,String name){
		Person person=null;
		if(id>0)
			person=new Person(id,name);
		else
			person=NullPerson.NULL;
		return person;
	}
}
