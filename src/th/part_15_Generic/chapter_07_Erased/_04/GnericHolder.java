package th.part_15_Generic.chapter_07_Erased._04;

public class GnericHolder<T> {
	private T obj;

	public T getObj() {
		return obj;
	}
	public void setObj(T obj) {
		this.obj = obj;
	}
	
	public static void main(String[] args) {
		GnericHolder<String> holder=new GnericHolder<String>();
		holder.setObj("Item");
		String s=holder.getObj();
		System.out.println(s);
	}
}
