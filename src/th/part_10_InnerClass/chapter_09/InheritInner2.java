package th.part_10_InnerClass.chapter_09;
/**
 * 10.9
 * �ڲ���ļ̳�
 * 
 * @author ken
 * 2016-9-23 ����02:04:01
 */
public class InheritInner2 extends WithInner.Innser2{
	//compile error InheritInner(){}
	/**
	 * �̳��ڲ���Ĺ��캯��
	 * ����ʹ����Χ�������--��
	 * enclosingClassReference.super();
	 */
	InheritInner2(WithInner withIn,String str){
		withIn.super(str);//ָ���ڲ��๹��
	}
	
	public static void main(String[] args) {
		WithInner with=new WithInner("test");
		InheritInner2 in=new InheritInner2(with,"str");
	}
}
