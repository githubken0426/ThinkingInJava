package th.part_10_InnerClass.chapter_10;
/**
 * ��ȷ�ļ̳�ĳ���ڲ���
 * 
 * @author ken
 * 2016-9-23 ����04:45:01
 */
public class Egg2 {
	
	protected class Yolk{
		public Yolk(){//Egg2 step 2
			System.out.println("Constructor Egg.Yolk!");
		}
		public void f(){
			System.out.println("Method Egg.Yolk.f()!");
		}
	}
	/**
	 * �๹�����˳��
	 * 1 ���ø���Ĺ��캯��
	 * 2 ��ʼ�����ֶ�
	 * 3 ���ع��캯��
	 */
	public Egg2(){// Egg2 step 3
		System.out.println("Constructor new Egg2()");
	}
	
	private Yolk yolk =new Yolk();//Egg2 step 1
	
	public void insertYolk(Yolk yolk){
		this.yolk=yolk;
	}
	public void g(){
		yolk.f();
	}
}
