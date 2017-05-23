package th.about.Assert;

/**
 * assert:断言表示为一些布尔表达式，程序员相信在程序中的某个特定点该表达式值为真
 * 
 * 1.如果<boolean表达式>为true，则程序继续执行。
 * 如果为false，则程序抛出AssertionError，并终止执行。
 * 
 *  2.assert <boolean表达式> : <错误信息表达式>
 *  如果<boolean表达式>为true，则程序继续执行。
 *  如果为false，则程序抛出java.lang.AssertionError，并输入<错误信息表达式>。
 *  
 *  Java在执行的时候默认是不启动断言检查的（这个时候，所有的断言语句都将忽略！），
 *  如果要开启断言检查，则需要用开关-enableassertions或-ea来开启
 */
public class AssertClass {
	//不开启开关，默认全部输出，开始后会报异常
	public static void test1(){
		assert true;
		System.out.println("断言1没有问题！");
		assert false : "断言失败，此表达式的信息将会在抛出异常的时候输出！";
        System.out.println("断言2没有问题！");
	}
	
	/**
	 * 1、assert关键字需要在运行时候显式开启才能生效，否则你的断言就没有任何意义。
	 * 而现在主流的Java IDE工具默认都没有开启-ea断言检查功能。
	 * 这就意味着你如果使用IDE工具编码，调试运行时候会有一定的麻烦。
	 * 并且，对于Java Web应用，程序代码都是部署在容器里面，你没法直接去控制程序的运行，
	 * 如果一定要开启-ea的开关，则需要更改Web容器的运行配置参数。这对程序的移植和部署都带来很大的不便。
	 * 
	 * 2、用assert代替if是陷阱之二。assert的判断和if语句差不多，
	 * 但两者的作用有着本质的区别：assert关键字本意上是为测试调试程序时使用的，
	 * 但如果不小心用assert来控制了程序的业务流程，
	 * 那在测试调试结束后去掉assert关键字就意味着修改了程序的正常的逻辑。
	 * 
	 * 3、assert断言失败将面临程序的退出。这在一个生产环境下的应用是绝不能容忍的。
	 * 一般都是通过异常处理来解决程序中潜在的错误。但是使用断言就很危险，一旦失败系统就挂了。
	 * @param args
	 */
	public static void main(String[] args) {
		test1();
	}
}
