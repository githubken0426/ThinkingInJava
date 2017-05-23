package th.part_17_DeepInCollection.chapter_02Fill._01Generator;

import java.util.ArrayList;

import TIJ4_code.net.mindview.util.Generator;
/**
 * Collection的构造器能接收另外一个Collection对象，用来填充容器
 * @author Administrator
 * 2016-4-20 上午09:06:44
 * @param <T>
 */
public class CollectionData<T> extends ArrayList<T> {
	private static final long serialVersionUID = 1L;

	public CollectionData(Generator<T> gen,int quantity){
		System.out.println("length:"+quantity);
		for(int i=0;i<quantity;i++){
			add(gen.next());
		}
	}
	
	public static <T> CollectionData<T> list(Generator<T> gen,int quantity){
		return new CollectionData<T>(gen,quantity);
	}
}
