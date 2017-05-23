package th.part_15_Generic.chapter_02_SimpleGeneric._00_SimpleGeneric;

public class Holder2 {
	private Object a;
	public Object getA() {
		return a;
	}
	public void setA(Object a) {
		this.a = a;
	}
	
	public Holder2(Object a){
		this.a=a;
	}
	
	public static void main(String[] args) {
		Holder2 ho=new Holder2(new AutoMobile());
		Holder2 h2=(Holder2) ho.getA();
		h2.setA("Note a AutoMobile!");
		String s=(String) h2.getA();
		h2.setA(1);
		Integer x=(Integer) h2.getA();
	}
}
