package th.part_15_Generic.chapter_08_ErasedCompnesate._01;

public abstract class GenericWithCreate<T> {
	abstract T create();
	final T t;
	GenericWithCreate(){
		System.out.println("GenericWithCreate");
		//Ĭ�ϵ���ʵ�ַ���
		t=create();
	}
	
	static class X{}
	static class Creator extends GenericWithCreate<X>{
		Creator(){
			System.out.println("��������Creator");
		}
		@Override
		GenericWithCreate.X create() {
			System.out.println("������create()");
			return new X();
		}
		void f(){
			System.out.println("f():"+t.getClass().getSimpleName());
		}
	}
	
	public static void main(String[] args) {
		Creator c=new Creator();
		c.f();
	}
}
