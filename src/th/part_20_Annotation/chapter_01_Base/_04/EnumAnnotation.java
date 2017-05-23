package th.part_20_Annotation.chapter_01_Base._04;

/**
 * 枚举类型结合注解
 * @author Administrator
 * 2016-4-7 下午01:43:47
 *
 */
public @interface EnumAnnotation {
	TestEnum value() default TestEnum.Test;
}
