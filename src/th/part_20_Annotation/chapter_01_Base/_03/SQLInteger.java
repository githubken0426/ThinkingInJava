package th.part_20_Annotation.chapter_01_Base._03;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLInteger {
	String name()default "";
	/**
	 * Ç¶Ì××¢½â£¬Ä¬ÈÏÖµunique=true,allowNull=false;
	 * @return
	 */
	Constraints  constraints()default @Constraints(primaryKey=true,unique=false,allowNull=false);
}
