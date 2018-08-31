package th.part_20_Annotation.packageinfo;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ElementType.PACKAGE将此主键声明为包
 * @author Administrator
 * 2016-3-31 上午11:30:34
 *
 */
@Documented
@Inherited
@Target(value={ElementType.PACKAGE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PackageAnnotation {
}
