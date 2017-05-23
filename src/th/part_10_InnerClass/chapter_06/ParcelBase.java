package th.part_10_InnerClass.chapter_06;

/**
 * ʵ����ʼ���ﵽ����������Ч��
 * 
 * @author ken
 * 2016-9-20 ����03:29:19
 */
public class ParcelBase {
	abstract class Base{
		public Base(int i){
			System.out.println("Base constructor "+i);
		}
		public abstract void f();
	}
	
	public static class AnonymousConstructor{
		/**
		 * i����Ҫfinal����Ϊi�Ǵ��ݸ����������Ĺ�����ʹ��
		 * �����ಢ��ֱ��ʹ��
		 * @param i
		 * @return
		 * 2016-9-21 ����10:32:36
		 */
		public  Base getBase(int i){
			return new ParcelBase().new Base(i){
				{System.out.println("Inside Instance Initializer");}
				@Override
				public void f() {
					System.out.println("In anonymous f()");
				}
			};
		}
	}
	public static void main(String[] args) {
		Base base=new AnonymousConstructor().getBase(47);
		base.f();
		
	}
}
