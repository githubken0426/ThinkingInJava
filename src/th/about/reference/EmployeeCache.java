package th.about.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Hashtable;

/**
 * ��Ա������
 * @author Administrator
 * 2015��9��16��
 */
public class EmployeeCache {
	 static private EmployeeCache employeeCache;		// һ��Cacheʵ�� ,���� 
	 private Hashtable<String,EmployeeRef> employeeRef;// ����Chche���ݵĴ洢  
	 private ReferenceQueue<Employee> queue;			// ����Reference�Ķ���  
	 
	 private class EmployeeRef extends SoftReference<Employee>{
		private String key="";
		public EmployeeRef(Employee referent,ReferenceQueue<Employee> queue) {
			super(referent,queue);
			key=referent.getId();
		}
	 }
	 
	 // ����һ��������ʵ��  
	 private EmployeeCache(){
		 employeeRef=new Hashtable<String,EmployeeRef>();
		 queue=new ReferenceQueue<Employee>();
	 }
	 
	 //��ȡ������ʵ��
	 public static EmployeeCache getInstance(){
		 if(employeeCache==null){
			 employeeCache=new EmployeeCache();
		 }
		 return employeeCache;
	 }
	 
	 // �����Щ�������õ�Employee�����Ѿ������յ�EmployeeRef����  
	 private void clearnCache(){
		 EmployeeRef ref=null;
		 System.out.println("queue.poll()"+queue.poll());
		 while((ref=(EmployeeRef) queue.poll())!=null){
			 employeeRef.remove(ref.key);
		 }
	 }
	 
	 // �������õķ�ʽ��һ��Employee�����ʵ���������ò����������
	 private void cacheEmployee(Employee emp){
		 this.clearnCache();
		 EmployeeRef ref=new EmployeeRef(emp, queue);
		 employeeRef.put(emp.getId(), ref);
	 }
	 
	 public Employee getEmployee(String id){
		 Employee emp=null;
		
		 if(employeeRef.containsKey(id)){
			 emp=employeeRef.get(id).get();
			 System.out.println("�����е�emp����:"+emp.getName());
		 }
		 if(emp==null){
			 emp=new Employee(id,"����","���۲�","15998556330");
			 this.cacheEmployee(emp);
			 System.out.println("Retrieve From EmployeeInfoCenter.id=" + id);
		 }
		 return emp;
	 }
	 
}
