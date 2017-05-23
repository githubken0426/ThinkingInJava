package th.part_14_TypeInfo.chapter_08_NullObject._01;

public class Position {
	private String title;
	private Person person;
	
	public Position(String title,Person employee){
		this.title=title;
		this.person=employee;
		if(person==null){
			person=Person.NULL;
		}
	}
	
	public Position(String title){
		this.title=title;
		person=Person.NULL;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person newPerson) {
		this.person = newPerson;
		if(person==null){
			person=Person.NULL;
		}
	}
	
	public String toString(){
		return "Position:"+title+" "+person;
	}
}
