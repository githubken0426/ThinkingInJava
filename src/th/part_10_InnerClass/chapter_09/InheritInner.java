package th.part_10_InnerClass.chapter_09;
/**
 * 10.9
 * �ڲ���ļ̳�
 * 
 * @author ken
 * 2016-9-23 ����02:04:01
 */
public class InheritInner extends WithInner.Innser{
	//compile error InheritInner(){}
	/**
	 * �̳��ڲ���Ĺ��캯��
	 * ����ʹ����Χ�������--��
	 * enclosingClassReference.super();
	 */
	InheritInner(WithInner withIn){
		withIn.super();//ָ���ڲ��๹��
	}
	
	public static void main(String[] args) {
		WithInner with=new WithInner("test");
		InheritInner in=new InheritInner(with);
	}
}
