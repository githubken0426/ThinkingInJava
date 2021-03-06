package jvm.stack;

/**
 * 2.栈调用
 * @ClassName: WhoCalled 
 * @Description: 
 * @author ken 
 * @date 2018年3月30日 上午11:33:09
 */
public class StackTrace {
	/**
	 * getStackTrace()方法返回一个由栈轨迹中的元素组成的数组
	 * 每个元素表示栈中的一帧
	 * 元素0(栈顶)是调用序列中的最后一个方法
	 * 栈底是最后一个方法调用
	 * 
	 * 2017-4-14 上午08:22:39
	 */
	static void f(){
		try {
			throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
			for (StackTraceElement ele : e.getStackTrace()) {
				System.out.println(ele.getMethodName());
			}
		}
	}
	static void g(){
		f();
	}
	public static void main(String[] args) {
		g();
	}
}
