package th.part_15_Generic.chapter_08_ErasedCompnesate._01;

public class ClassAsFactory<T> {
	T x;
	public ClassAsFactory(Class<T> kind) {
		try {
			x=kind.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} 
	}
	
}
