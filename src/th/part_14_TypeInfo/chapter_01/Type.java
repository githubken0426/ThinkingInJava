package th.part_14_TypeInfo.chapter_01;

public class Type<T> {
	private String name;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	Type(){}
	
	Type(String name){
		this.name=name;
	}
	
	public T newInstance(){
		return null;
	}
}
