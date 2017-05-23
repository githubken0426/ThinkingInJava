package th.part_20_Annotation.chapter_01_Base._03;

import th.part_20_Annotation.chapter_01_Base._01.Test;

/**
 * java bean
 * @author Administrator
 * 2015-12-31 ����09:41:30
 *
 */
@DBTable(name="bl_member")
public class Member {
	/**
	 * valueʹ���˿�ݷ�ʽ
	 * ʹ�õ�ʱ��������ʾ����value,ֱ�Ӹ�ֵ����
	 * 1:@SQLString(value=30)String firstName.2:@SQLString(50)String lastName;
	 * 
	 * ȱ���Ǳ�������Ԫע��Ϊvalue
	 * 
	 * Ҳ����ʹ�ö�ע�⣬ͬһ��ע�ⲻ���ظ�ʹ��
	 * @return
	 */
	@SQLString(value=30,name="����") @Test String firstName;
	@SQLString(50) String lastName;
	@SQLInteger(name="����") int age;
	@SQLString(value=30,name="����",constraints=@Constraints(primaryKey=true))String handle;
	static int memberCount;
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public int getAge() {
		return age;
	}
	public String getHandle() {
		return handle;
	}
	
}
