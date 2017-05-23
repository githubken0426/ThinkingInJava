package th.part_15_Generic.chapter_07_Erased._03;
/**
 * 15.7.3
 * ����������
 * 
 * @author ken
 * @param <T>
 * 2016-9-30 ����08:45:24
 */
public class GenericBase<T> {
	private T ele;

	public T getEle() {
		return ele;
	}
	public void setEle(T ele) {
		this.ele = ele;
	}
	class Drived1<T> extends GenericBase<T>{}
	class Drived2 extends GenericBase{}
	/**
	 * compile error
	 * 
	 */
//	class Drived3 extends GenericBase<?>{}
	
	public static void main(String[] args) {
		GenericBase.Drived2 d2=new GenericBase().new Drived2();
		Object obj=d2.getEle();
		d2.setEle(obj);
	}
}
