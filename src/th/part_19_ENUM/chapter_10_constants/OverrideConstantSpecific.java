package th.part_19_ENUM.chapter_10_constants;

/**
 * ���ǳ����ķ���
 * 
 * @author ken
 * 2017-5-2 ����04:59:27
 */
public enum OverrideConstantSpecific {
	NUT,BOLT,WASHER{
		void f(){
			System.out.println("override method");
		}
	};
	void f(){
		System.out.println("default behavior");
	}
	public static void main(String[] args) {
		for (OverrideConstantSpecific ele : values()) {
			System.out.print(ele+":");
			ele.f();
		}
	}
}
