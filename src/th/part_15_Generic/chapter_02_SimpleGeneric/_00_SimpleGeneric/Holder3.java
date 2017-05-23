package th.part_15_Generic.chapter_02_SimpleGeneric._00_SimpleGeneric;

public class Holder3<T> {
	private T t;
	
	/**
	 * compile error:
	 * Name clash: The method equals(T) of type Holder3<T> 
	 * has the same erasure as equals(Object) of 
	 * type Object but does not override it.
	 * 
	 * 1.���෽��Ҫ���ǣ������븸�෽��������ͬ�ķ���ǩ����������+�����б���
	 *   ���ұ��뱣֤����ķ���Ȩ��>=����ķ���Ȩ��;
	 * 2.������������Pair<T>�е�equals(T)����ʱ��
	 * 	 ��һ��Ӧ��Ȼ��equals(T)û�и���ס����Object�е�equals(Object)�ˡ�
       3.���š������������ʹ����е�T��Object�������������
       	 ͻȻ���ֲ����Ժ�equals(T)�����equals(Object)������ˣ����������Object���е�equalsһ����
	 * @param t
	 */
	/*public boolean equals(T a){
		return a.equals(t);
	}*/
	
	
	public  Holder3(T t){
		this.t=t;
	}
	
	public T get(){
		return t;
	}
	
	public void set(T t){
		this.t=t;
	}
	
	public static void main(String[] args) {
		Holder3<AutoMobile> h3=new Holder3<AutoMobile>(new AutoMobile());
		AutoMobile au=h3.get();
	}
}
