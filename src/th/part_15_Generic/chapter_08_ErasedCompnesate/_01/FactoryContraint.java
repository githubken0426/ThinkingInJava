package th.part_15_Generic.chapter_08_ErasedCompnesate._01;

 
public class FactoryContraint {
	public interface Factory1<T> {
		T create();
	}
	 class Foo2<T>{
		private T t;
		public <F extends Factory1<T>> Foo2(F factory){
			t=factory.create();
		}
	}
	class IntegerFactory implements Factory1<Integer>{
		
		@Override
		public Integer create() {
			System.out.println("Integer");
			return new Integer(0);
		}
	}
	
	static class Widget{
		public static class Factory implements FactoryContraint.Factory1<Widget>{
			@Override
			public Widget create() {
				System.out.println("Widget");
				return new Widget();
			}
		}
	}
	
	public static void main(String[] args) {
		FactoryContraint fc=new FactoryContraint();
		fc.new Foo2<Integer>(fc.new IntegerFactory());
		fc.new Foo2<Widget>(new Widget.Factory());
	}
}
