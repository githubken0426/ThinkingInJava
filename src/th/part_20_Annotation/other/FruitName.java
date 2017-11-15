package th.part_20_Annotation.other;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 水果名称注解
 * @ClassName: FruitName 
 * @Description: 
 * @author ken 
 * @date 2017年11月15日 下午2:49:33
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FruitName {
	String value() default "";
}
