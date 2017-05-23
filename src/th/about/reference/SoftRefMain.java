package th.about.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * ������
 * @author Administrator
 * 2015��9��16��
 */
public class SoftRefMain {
	/**
	 * �����ж�:
	 * ����������·���ɼ����ж�:  ������·���У�������һ�����þ�������Ŀɼ��ԡ�
	 * ����������·���ɼ����ж�:  ����·���У���ǿ��һ�������þ�������Ŀɼ��ԡ�
	 * @param args
	 *	2015��9��16��
	 */
	public static void main(String[] args) {
		
		ReferenceQueue queue=new ReferenceQueue();
		
		Employee emp =new Employee("SN001","����","���۲�","15998556330");//ǿ����
		
		SoftReference softEmp=new SoftReference(emp,queue);//SoftReference�๹����person��������
		
		/**
		 * ����������·����һ��������SoftReference����������ã�һ�����Ա���emp��ǿ���ã�
		 * �������person������ǿ�ɼ�����
		 */
		emp=null;//���emp�����Ϊ����ɼ�����
		
		if(emp==null){
			emp=new Employee("SN001","����","���۲�","15998556330");
			System.out.println("Strong:"+emp.getName());
		}else{
			//get()�������»�öԸ�ʵ����ǿ���ã�������󱻻��գ�get()����null
			emp=(Employee) softEmp.get();
			System.out.println("Soft:"+emp.getName());
		}
		
	}
}
