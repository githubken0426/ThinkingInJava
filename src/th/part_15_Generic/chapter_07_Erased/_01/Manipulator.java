package th.part_15_Generic.chapter_07_Erased._01;

public class Manipulator<T> {
	private T obj;
	
	public Manipulator(T obj){
		this.obj=obj;
	}
	public void manipulator(){
//		obj.f();//compile error 
	}
}
