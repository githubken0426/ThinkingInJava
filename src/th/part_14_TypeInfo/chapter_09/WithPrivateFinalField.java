package th.part_14_TypeInfo.chapter_09;

public class WithPrivateFinalField {
	private int i=2;
	private final String str="I am total safe";
	private String s2="Am i safe?";
	
	public String toString(){
		return "i="+i+","+str+","+s2;
	}
}
