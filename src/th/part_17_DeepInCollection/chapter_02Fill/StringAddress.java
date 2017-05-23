package th.part_17_DeepInCollection.chapter_02Fill;

public class StringAddress {
	private String address;
	
	public StringAddress(String address){
		this.address=address;
	}
	
	public String toString(){
		return super.toString()+"-->"+ this.address;
	}
}
