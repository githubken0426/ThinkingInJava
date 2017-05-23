package th.part_20_Annotation.chapter_01_Base._01;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解元素只能是基本数据类型，包含：
 * String Class enum annotation(嵌套注解) 
 * 以及以上类型的数组。
 * @author Administrator
 * 2015-12-31 上午09:10:50
 *
 */
//ElementType可以用逗号分隔的形式指定多个值，也可以将@Target省略，代表指全部值。
@Target(value={ElementType.METHOD,ElementType.TYPE,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserCase {
	public int id();
	public String description()default "no description";
}
