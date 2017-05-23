package th.part_17_DeepInCollection.chapter_06Set;

import java.util.HashSet;

public class Person {
	private int age;
	private String name;
	
	public Person(String name,int age){
		this.age=age;
		this.name=name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public int hashCode(){
		int result=name.hashCode()+age*21;
		System.out.println(name+"-->"+result);
		return result;
	}
	
	public boolean equals(Object o){
		if(this==o)
			return true;
		if(o instanceof Person){
			Person p=(Person) o;
			System.out.println(p.getName().equals(name) && p.getAge()==age);
			return p.getName().equals(name) && p.getAge()==age;
		}
		return false;
	}
	
	public String toString(){
        return name + "--" + age;
    }
	
	
	public static void main(String[] args) {
		HashSet<Person> hs = new HashSet<Person>();
        Person p = new Person("张三", 21);
        hs.add(p);
        System.out.println(hs);
        
        p.setName("李四");
        p.setAge(22);
        hs.add(p);

        System.out.println(hs);
        
        
	}
}
