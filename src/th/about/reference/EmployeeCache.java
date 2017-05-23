package th.about.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Hashtable;

/**
 * 雇员缓存类
 * @author Administrator
 * 2015年9月16日
 */
public class EmployeeCache {
	 static private EmployeeCache employeeCache;		// 一个Cache实例 ,单例 
	 private Hashtable<String,EmployeeRef> employeeRef;// 用于Chche内容的存储  
	 private ReferenceQueue<Employee> queue;			// 垃圾Reference的队列  
	 
	 private class EmployeeRef extends SoftReference<Employee>{
		private String key="";
		public EmployeeRef(Employee referent,ReferenceQueue<Employee> queue) {
			super(referent,queue);
			key=referent.getId();
		}
	 }
	 
	 // 构建一个缓存器实例  
	 private EmployeeCache(){
		 employeeRef=new Hashtable<String,EmployeeRef>();
		 queue=new ReferenceQueue<Employee>();
	 }
	 
	 //获取缓存器实例
	 public static EmployeeCache getInstance(){
		 if(employeeCache==null){
			 employeeCache=new EmployeeCache();
		 }
		 return employeeCache;
	 }
	 
	 // 清除那些所软引用的Employee对象已经被回收的EmployeeRef对象  
	 private void clearnCache(){
		 EmployeeRef ref=null;
		 System.out.println("queue.poll()"+queue.poll());
		 while((ref=(EmployeeRef) queue.poll())!=null){
			 employeeRef.remove(ref.key);
		 }
	 }
	 
	 // 以软引用的方式对一个Employee对象的实例进行引用并保存该引用
	 private void cacheEmployee(Employee emp){
		 this.clearnCache();
		 EmployeeRef ref=new EmployeeRef(emp, queue);
		 employeeRef.put(emp.getId(), ref);
	 }
	 
	 public Employee getEmployee(String id){
		 Employee emp=null;
		
		 if(employeeRef.containsKey(id)){
			 emp=employeeRef.get(id).get();
			 System.out.println("缓存中的emp对象:"+emp.getName());
		 }
		 if(emp==null){
			 emp=new Employee(id,"李四","销售部","15998556330");
			 this.cacheEmployee(emp);
			 System.out.println("Retrieve From EmployeeInfoCenter.id=" + id);
		 }
		 return emp;
	 }
	 
}
