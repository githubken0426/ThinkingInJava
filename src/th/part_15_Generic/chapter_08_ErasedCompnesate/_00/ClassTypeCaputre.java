package th.part_15_Generic.chapter_08_ErasedCompnesate._00;


/**
 * ��Ϊ������Ϣ�����������Բ���ʹ��instanceof
 * ����ʹ�ö�̬��isInstance()����
 * 
 * @author ken
 * @param <T>
 * 2016-9-30 ����11:04:19
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
