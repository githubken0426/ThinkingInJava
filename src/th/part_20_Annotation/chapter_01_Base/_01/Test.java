package th.part_20_Annotation.chapter_01_Base._01;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Target	��ʾ��ע���������ʲô�ط������ܵ�ElementType����������
 * 
 * CONSTRUCTOR:������������
 * FIELD:������������enumʵ����
 * LOCAL_VARIABLE:�ֲ���������
 * METHOD:��������
 * PACKAGE:������,�˴�ע�������package-info.java�ļ���
 * PATAMETER:��������
 * TYPE:�ࡢ�ӿڣ�����ע�����ͣ���enum����
 * 
 * @Retention	��ʾ��Ҫ��ʲô���𱣴��ע����Ϣ����ѡ��RetentionPolicy����������
 * SOURCE:ע�⽫������������
 * CLASS:ע����class�ļ��п��ã����ᱻJVM����
 * RUNTIME:VM����������Ҳ����ע�⣬��˿���ͨ��������ƶ�ȡע�����Ϣ
 * 
 * @Documented	����ע�������Javadoc��
 * 
 * @Inherited	��������̳и����е�ע��
 * 
 * @author Administrator
 * 2016-3-31 ����11:30:34
 *
 */
@Documented
@Inherited
@Target(value={ElementType.PACKAGE,ElementType.METHOD,ElementType.FIELD,ElementType.CONSTRUCTOR,
		ElementType.PARAMETER,ElementType.TYPE,ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
}
