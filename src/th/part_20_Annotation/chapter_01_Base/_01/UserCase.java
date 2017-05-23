package th.part_20_Annotation.chapter_01_Base._01;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ע��Ԫ��ֻ���ǻ����������ͣ�������
 * String Class enum annotation(Ƕ��ע��) 
 * �Լ��������͵����顣
 * @author Administrator
 * 2015-12-31 ����09:10:50
 *
 */
//ElementType�����ö��ŷָ�����ʽָ�����ֵ��Ҳ���Խ�@Targetʡ�ԣ�����ָȫ��ֵ��
@Target(value={ElementType.METHOD,ElementType.TYPE,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserCase {
	public int id();
	public String description()default "no description";
}
