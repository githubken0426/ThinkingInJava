package th.part_15_Generic.chapter_07_Erased._01;

public class Manipulator2<T extends HasF> {
private T obj;
	
	public Manipulator2(T obj){
		this.obj=obj;
	}
	public void manipulator2(){
		obj.f();
	}
}
