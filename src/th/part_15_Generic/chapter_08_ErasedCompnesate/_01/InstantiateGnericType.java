package th.part_15_Generic.chapter_08_ErasedCompnesate._01;


class Employee{
}

public class InstantiateGnericType {
	public static void main(String[] args) {
		ClassAsFactory<Employee> caf=new ClassAsFactory<Employee>(Employee.class);
		/**
		 * newInstance()����ȱʡ�޲ι���
		 * Integerû���޲ι���
		 */
		try {
			ClassAsFactory<Integer> cafIn=new ClassAsFactory<Integer>(Integer.class);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ClassAsFactory<Integer> Faild!");
		}
		
	}
}
