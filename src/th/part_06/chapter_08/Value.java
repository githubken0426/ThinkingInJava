package th.part_06.chapter_08;

public class Value {
	int i=1;
	
	private static int counter;
    private int id = counter ++;
    
    public String toString(){
        return String.valueOf(id);
    }
}
