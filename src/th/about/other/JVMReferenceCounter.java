package th.about.other;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;


/**
 * �������>>���ü�����
 * @author Administrator
 * 2015��9��17��
 */
public class JVMReferenceCounter {
	private byte[] buffer;  
      
	private List ls;
    private List getList() {  
        return ls;  
    }  
	
    public JVMReferenceCounter() {  
        this.buffer= new byte[4 * 1024 * 1024];  
        this.ls = new ArrayList();  
    }  
    
  
    public static void main(String[] args) {  
    	JVMReferenceCounter t1 = new JVMReferenceCounter();  
    	JVMReferenceCounter t2 = new JVMReferenceCounter(); 
        t1.getList().add(t2);  
        t2.getList().add(t1);  
        t1 = t2 = null;  
        
        JVMReferenceCounter t3 = new JVMReferenceCounter();  
        System.out.println(t3); 
    }  
}
