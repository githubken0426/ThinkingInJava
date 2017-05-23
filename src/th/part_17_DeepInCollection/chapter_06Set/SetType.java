package th.part_17_DeepInCollection.chapter_06Set;

public class SetType {
	int i;
	public SetType(int i){
		this.i=i;
	}
	
	public boolean equals(Object o){
		return o instanceof SetType && i==((SetType)o).i;
	}
	
	public String toString(){
		return Integer.toString(i);
	}
}
