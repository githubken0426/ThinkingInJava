package th.part_14_TypeInfo.chapter_02._02;

import java.util.ArrayList;
import java.util.List;

public class FieldList<T> {
	public Class<T> type;
	public FieldList(Class<T> type){
		this.type=type;
	}
	
	public List<T> createElement(int element){
		List<T> result =new ArrayList<T>();
		try {
			for(int i=0;i<element;i++){
				result.add(type.newInstance());
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		}catch( IllegalAccessException e){
			e.printStackTrace();
		}
		return result;
	}
	
	public static void main(String[] args) {
		FieldList<CountInteger> fields= new FieldList<CountInteger>(CountInteger.class);
		System.out.println(fields.createElement(15));
		
		for(int i=0;i<5;i++){
			CountInteger c=new CountInteger();
			System.out.println(c);
		}
	}

	

}
