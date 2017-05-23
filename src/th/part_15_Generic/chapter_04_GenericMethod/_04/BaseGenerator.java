package th.part_15_Generic.chapter_04_GenericMethod._04;

import th.util.Generator;

public class BaseGenerator<T> implements Generator<T> {
	private Class<T> type;
	
	public BaseGenerator(Class<T> type){
		this.type=type;
	}
	@Override
	public T next() {
		try {
			//Assumes 'type' is a public class
			return type.newInstance();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	//produce a default Generator given a type token
	public static <T> Generator<T> create(Class<T> type){
		return new BaseGenerator(type);
	}
}
