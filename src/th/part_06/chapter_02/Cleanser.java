package th.part_06.chapter_02;

public class Cleanser {
	public String s=new String("Cleanser ");
	public void append(String a){
		s+=a;
	} 
	protected void dulite(){
		append("dulite()");
	}
	public void apply(){
		append("apply()");
	}
	public void scrub(){
		append("scrub()");
	}
	public static void main(String[] args) {
		Cleanser cleanser=new Cleanser();
		cleanser.dulite();
		cleanser.apply();
		cleanser.scrub();
		System.out.println(cleanser.s);
	}
	public final void getAll(){
		System.out.println("方法不能重写或改变！");
	}
}

