/**   
 * <b>package-info不是平常类，其作用有三个:</b><br>   
 * 1、为标注在包上Annotation提供便利；<br>   
 * 2、声明包的私有类和常量；(比如一个包中有很多的内部访问的类或常量，就可以统一的放到package-info类中，这样就方便，而且集中管理，减少friendly类到处游走的情况.)<br>   
 * 3、提供包的整体注释说明。(如果是分“包”开发，也就是说一个包实现一个业务逻辑或功能点、或模块、或组件，则需要对一个包有很好的说明，说明这个包是干啥的，有啥作用，版本变迁，特别说明等等)<br>   
 *  
 * @author   
*/

@PackageAnnotation
package th.part_20_Annotation.packageinfo;

class PackageInfo {
	public void common() {
		System.out.println("sa");
	}
}

class PackageInfoGeneric<T extends Throwable> {
	private T obj;

	public void set(T obj) {
		this.obj = obj;
	}

	public void common() {
		System.out.println(obj + "sa");
	}
}

interface PackageInfoInterface {
	public void test();
}

class PackageConstants {
	public static final String ERROE_CODE = "100001";
}