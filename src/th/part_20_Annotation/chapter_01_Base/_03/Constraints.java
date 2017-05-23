package th.part_20_Annotation.chapter_01_Base._03;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(value={ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Constraints {
	boolean primaryKey()default false;
	boolean allowNull()default true;
	boolean unique()default false;
}
