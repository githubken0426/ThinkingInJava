package concurrent.practice.net.jcip.annotations;

public @interface GuardedBy{

	String value() default "";

}
