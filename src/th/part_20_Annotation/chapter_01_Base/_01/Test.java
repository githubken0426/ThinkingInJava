package th.part_20_Annotation.chapter_01_Base._01;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Target	表示该注解可以用于什么地方。可能的ElementType参数包括：
 * 
 * CONSTRUCTOR:构造器的声明
 * FIELD:域声明（包括enum实例）
 * LOCAL_VARIABLE:局部变量声明
 * METHOD:方法声明
 * PACKAGE:包声明,此处注解必须在package-info.java文件里
 * PATAMETER:参数声明
 * TYPE:类、接口（包括注解类型）或enum声明
 * 
 * @Retention	表示需要在什么级别保存该注解信息。可选的RetentionPolicy参数包括：
 * SOURCE:注解将被编译器丢弃
 * CLASS:注解在class文件中可用，但会被JVM丢弃
 * RUNTIME:VM将在运行期也保留注解，因此可以通过反射机制读取注解的信息
 * 
 * @Documented	将此注解包含在Javadoc中
 * 
 * @Inherited	允许子类继承父类中的注解
 * 
 * @author Administrator
 * 2016-3-31 上午11:30:34
 *
 */
@Documented
@Inherited
@Target(value={ElementType.PACKAGE,ElementType.METHOD,ElementType.FIELD,ElementType.CONSTRUCTOR,
		ElementType.PARAMETER,ElementType.TYPE,ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
}
