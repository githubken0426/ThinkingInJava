package th.part_15_Generic.chapter_07_Erased._04;

public class SimpleHolder<T> {
	private Object obj;

	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	public static void main(String[] args) {
		SimpleHolder<String> holder=new SimpleHolder<String>();
		holder.setObj("Item");
		System.out.println(holder.getObj());
	}
}
