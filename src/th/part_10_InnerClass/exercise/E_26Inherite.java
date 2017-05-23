package th.part_10_InnerClass.exercise;

public class E_26Inherite {
	class Inner1{
		class Inner{
			Inner(String str){}
		}
	}
	
	class Inner2{
		class InnerTest extends Inner1.Inner{
			/**
			 * �̳��ڲ����
			 * ���캯��������һ�����ڲ������Χ�������
			 * @param inner
			 * @param str
			 */
			InnerTest(E_26Inherite.Inner1 inner,String str){
				inner.super(str);
				System.out.println(str);
			}
		}
	}
	
	public static void main(String[] args) {
		E_26Inherite enclose=new E_26Inherite();
		Inner2 inner2=enclose.new Inner2();
		Inner2.InnerTest test=inner2.new InnerTest(enclose.new Inner1(),"test");
	}
}
