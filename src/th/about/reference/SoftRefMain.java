package th.about.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * 软引用
 * @author Administrator
 * 2015年9月16日
 */
public class SoftRefMain {
	/**
	 * 引用判断:
	 * ◆单条引用路径可及性判断:  在这条路径中，最弱的一个引用决定对象的可及性。
	 * ◆多条引用路径可及性判断:  几条路径中，最强的一条的引用决定对象的可及性。
	 * @param args
	 *	2015年9月16日
	 */
	public static void main(String[] args) {
		
		ReferenceQueue queue=new ReferenceQueue();
		
		Employee emp =new Employee("SN001","李四","销售部","15998556330");//强引用
		
		SoftReference softEmp=new SoftReference(emp,queue);//SoftReference类构造了person的软引用
		
		/**
		 * 有两个引用路径，一个是来自SoftReference对象的软引用，一个来自变量emp的强引用，
		 * 所以这个person对象是强可及对象。
		 */
		emp=null;//这个emp对象成为了软可及对象
		
		if(emp==null){
			emp=new Employee("SN001","李四","销售部","15998556330");
			System.out.println("Strong:"+emp.getName());
		}else{
			//get()方法重新获得对该实例的强引用，如果对象被回收，get()返回null
			emp=(Employee) softEmp.get();
			System.out.println("Soft:"+emp.getName());
		}
		
	}
}
