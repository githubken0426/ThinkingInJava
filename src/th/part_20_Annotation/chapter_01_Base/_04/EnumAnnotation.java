package th.part_20_Annotation.chapter_01_Base._04;

/**
 * ö�����ͽ��ע��
 * @author Administrator
 * 2016-4-7 ����01:43:47
 *
 */
public @interface EnumAnnotation {
	TestEnum value() default TestEnum.Test;
}
