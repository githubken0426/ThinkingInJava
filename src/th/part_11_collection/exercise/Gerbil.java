package th.part_11_collection.exercise;

public class Gerbil {
	private int gerbilNumber;
	private String name;
	
	
	public int getGerbilNumber() {
		return gerbilNumber;
	}

	public void setGerbilNumber(int gerbilNumber) {
		this.gerbilNumber = gerbilNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gerbil(){}
	
	public Gerbil(int gerbilNumber){
		this.gerbilNumber=gerbilNumber;
	}
	public Gerbil(int gerbilNumber,String name){
		this.gerbilNumber=gerbilNumber;
		this.name=name;
		
	}
	public String toString(){
		return "gerbil:"+this.gerbilNumber+",ĞÕÃû£º"+name;
	}
	public void hop(){
		System.out.println(this+" is hopping!");
	}
}
