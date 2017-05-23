package importNew.unkownAboutJava_10;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;


/**
 * 疯狂的注解
 * @author Administrator
 * 2016-3-4 上午09:57:44
 *
 */

@Target(ElementType.LOCAL_VARIABLE)//注解在局部变量的声明
public @interface Crazy {
	
}
