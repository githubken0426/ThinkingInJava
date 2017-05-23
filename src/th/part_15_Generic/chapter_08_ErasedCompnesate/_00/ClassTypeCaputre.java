package th.part_15_Generic.chapter_08_ErasedCompnesate._00;


/**
 * 因为类型信息被擦除，所以不能使用instanceof
 * 可以使用动态的isInstance()方法
 * 
 * @author ken
 * @param <T>
 * 2016-9-30 上午11:04:19
 */
class Building {}
class House extends Building {}

public class ClassTypeCaputre<T> {
	Class<T> kind;
	public ClassTypeCaputre(Class<T> kind){
		this.kind=kind;
	}
	
	public boolean f(Object obj){
		System.out.print("args:"+obj.getClass().getSimpleName()+",");
		return kind.isInstance(obj);
	}
	
	public static void main(String[] args) {
		ClassTypeCaputre<Building> ctc=new ClassTypeCaputre<Building>(Building.class);
		System.out.println(ctc.f(new Building()));
		System.out.println(ctc.f(new House()));
		
		ClassTypeCaputre<House> ctc2=new ClassTypeCaputre<House>(House.class);
		System.out.println(ctc2.f(new Building()));
		System.out.println(ctc2.f(new House()));
	}
}
