package th.part_20_Annotation.chapter_01_Base._03;

import th.part_20_Annotation.chapter_01_Base._01.Test;

/**
 * java bean
 * @author Administrator
 * 2015-12-31 上午09:41:30
 *
 */
@DBTable(name="bl_member")
public class Member {
	/**
	 * value使用了快捷方式
	 * 使用的时候无需显示调用value,直接赋值即可
	 * 1:@SQLString(value=30)String firstName.2:@SQLString(50)String lastName;
	 * 
	 * 缺点是必须设置元注解为value
	 * 
	 * 也可以使用多注解，同一个注解不能重复使用
	 * @return
	 */
	@SQLString(value=30,name="姓氏") @Test String firstName;
	@SQLString(50) String lastName;
	@SQLInteger(name="年龄") int age;
	@SQLString(value=30,name="测试",constraints=@Constraints(primaryKey=true))String handle;
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
