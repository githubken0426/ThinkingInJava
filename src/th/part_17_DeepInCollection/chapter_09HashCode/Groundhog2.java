package th.part_17_DeepInCollection.chapter_09HashCode;

public class Groundhog2 extends Groundhog{

	public Groundhog2(int number) {
		super(number);
	}
	public int hashCode(){
		return number;
	}
	public boolean equals(Object o){
		//instanceof������oΪnull�򷵻�false
		return o instanceof Groundhog2 && number==((Groundhog2)o).number;
	}
}
